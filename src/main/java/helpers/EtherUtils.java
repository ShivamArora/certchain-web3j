package helpers;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;

public class EtherUtils {
    private static Web3j web3j;
    private static Credentials credentials;
    private static String cAddress;

    private static EtherUtils etherUtils;
    private EtherUtils(){}

    public static EtherUtils init(Web3Instance web3Instance, UserCredentials userCredentials, String contractAddress){
        web3j = web3Instance.getWeb3j();
        credentials = userCredentials.getCredentials();
        cAddress = contractAddress;
        etherUtils = new EtherUtils();
        return etherUtils;
    }

    public static EtherUtils getInstance() throws IllegalStateException{
        if(etherUtils!=null){
            return etherUtils;
        }
        else{
            throw new IllegalStateException("Ether Utils not initialized");
        }
    }

    public void transferEthers(String toAddress, BigDecimal etherAmount){
        TransactionManager transactionManager = new RawTransactionManager(web3j,credentials);
        Transfer transfer = new Transfer(web3j,transactionManager);
        try {
            System.out.println("Ether calculated: "+DefaultGasProvider.GAS_PRICE.multiply(DefaultGasProvider.GAS_LIMIT));
            TransactionReceipt transactionReceipt = transfer.sendFunds(toAddress, etherAmount, Convert.Unit.ETHER).send();
            System.out.println("Ether transferred:"+transactionReceipt);
            System.out.println("From: "+transactionReceipt.getFrom()+" To: "+transactionReceipt.getTo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
