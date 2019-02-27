package helpers;

import exceptions.InsufficientFundsException;
import models.Document;
import models.Entity;
import models.TransferContract;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tuples.generated.Tuple6;
import org.web3j.tx.gas.DefaultGasProvider;
import web3j.contracts.DocumentHelper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DocumentUtils {
    private static Web3j web3j;
    private static Credentials credentials;
    private static String cAddress;
    private static DocumentHelper helper;

    private static DocumentUtils documentUtils;
    private DocumentUtils(){}

    public static DocumentUtils init(Web3Instance web3Instance, UserCredentials userCredentials, String contractAddress){
        web3j = web3Instance.getWeb3j();
        credentials = userCredentials.getCredentials();
        cAddress = contractAddress;
        helper = DocumentHelper.load(cAddress,web3j,credentials,new DefaultGasProvider());
        documentUtils = new DocumentUtils();
        return documentUtils;
    }

    public static DocumentUtils getInstance() throws IllegalStateException{
        if(documentUtils!=null){
            return documentUtils;
        }
        else{
            throw new IllegalStateException("Document Utils not initialized");
        }
    }


    public Document searchByDocumentHash(String docHash){
        Document document = new Document();
        Tuple6<String,String,String,String,String,String> result = null;
        try {
            result = helper.getDocumentByHash(docHash).sendAsync().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if(result==null){
            return null;
        }

        document.setHash(result.getValue1());
        document.setTitle(result.getValue2());
        document.setUrl(result.getValue3());
        document.setDescription(result.getValue4());
        document.setIssuer(new Entity(null,null,null,result.getValue5()));
        document.setReceiver(new Entity(null,null,null,result.getValue6()));

        return document;
    }

    public String createDocument(Document document) throws InsufficientFundsException {
        TransactionReceipt receipt = null;
        System.out.println("Uploader Address: "+credentials.getAddress());
        try {
            receipt = helper.createDocument(document.getHash(),document.getTitle(),document.getUrl(),document.getDescription()).sendAsync().get();
            return receipt.getTransactionHash();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
            if(e.getMessage().contains("insufficient funds"))
                throw new InsufficientFundsException();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            if(e.getMessage().contains("insufficient funds"))
                throw new InsufficientFundsException();
        }
        return "";
    }

    public String transferDocument(TransferContract transferContract){
        TransactionReceipt receipt = null;
        try{
            Long index = getIndexFromDocHash(transferContract.getDocHash());
            if(index != -1L) {
                receipt = helper.transferDocument(credentials.getAddress(), transferContract.getRecipientAddress(), BigInteger.valueOf(index)).sendAsync().get();
                return receipt.getTransactionHash();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
            return "Insufficient Funds to perform transaction.";
        }
        return "";
    }

    public List<Document> getDocumentsUnissued(String entityAddress){
        List<BigInteger> resultList = new ArrayList<>();
        List<Document> documentList = new ArrayList<>();
        try {
            resultList = helper.getDocumentsUnissued(entityAddress).sendAsync().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Result List Unissued: "+resultList);
        return getDocumentListFromIndexList(resultList, documentList);
    }

    public List<Document> getDocumentsIssued(String entityAddress){
        List<BigInteger> resultList = new ArrayList<>();
        List<Document> documentList = new ArrayList<>();
        try {
            resultList = helper.getDocumentsIssued(entityAddress).sendAsync().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Result List Issued: "+resultList);
        return getDocumentListFromIndexList(resultList, documentList);
    }

    public List<Document> getDocumentsReceived(String entityAddress){
        List<BigInteger> resultList = new ArrayList<>();
        List<Document> documentList = new ArrayList<>();
        try {
            resultList = helper.getDocumentsReceived(entityAddress).sendAsync().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Result List Received: "+resultList);
        return getDocumentListFromIndexList(resultList,documentList);
    }

    private Long getIndexFromDocHash(String docHash){
        try {
            return helper.getIndexFromHash(docHash).sendAsync().get().longValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return -1L;
    }

    private Document getDocumentByIndex(Long index){
        Tuple4<String,String,String,String> result = null;
        Document document = null;
        try{
            result = helper.getDocument(BigInteger.valueOf(index)).sendAsync().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        document = new Document(result.getValue1(),result.getValue2(),result.getValue3(),null,null,null,result.getValue4());
        return document;
    }

    private List<Document> getDocumentListFromIndexList(List<BigInteger> resultList, List<Document> documentList) {
        for (int i = 0; i < resultList.size(); i++) {
            Document document = getDocumentByIndex(resultList.get(i).longValue());
            documentList.add(document);
            System.out.println(document);
        }
        return documentList;
    }
}
