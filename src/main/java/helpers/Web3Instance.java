package helpers;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;
import web3j.contracts.DocumentHelper;


import java.util.List;
import java.util.concurrent.ExecutionException;

public class Web3Instance {
    private static Web3Instance instance;
    private static Web3j web3j;
    private Web3Instance(){}

    public static Web3Instance initWeb3(String web3ServiceUrl){
        if(instance == null || web3j==null){
            web3j = Web3j.build(new HttpService(web3ServiceUrl));
            instance = new Web3Instance();
            return instance;
        }
        return instance;
    }

    public void checkRunningClientVersion(){
        try {
            Web3ClientVersion clientVersion = web3j.web3ClientVersion().sendAsync().get();

            if(!clientVersion.hasError()){
                System.out.println("Client is running version: "+clientVersion.getWeb3ClientVersion());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public Web3j getWeb3j() {
        return web3j;
    }

    public Long getCurrentBlockNumber(){
        EthBlockNumber result = new EthBlockNumber();
        try {
            result = web3j.ethBlockNumber().sendAsync().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Eth Block: "+result.getBlockNumber());
        return result.getBlockNumber().longValue();
    }

    public List<String> listAccounts(){
        EthAccounts accounts = new EthAccounts();
        try {
            accounts = web3j.ethAccounts().sendAsync().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Eth Accounts: "+accounts.getAccounts());
        return accounts.getAccounts();
    }

    public Long getTransactionsCount(String userAddress){
        EthGetTransactionCount count = new EthGetTransactionCount();
        try {
            count = web3j.ethGetTransactionCount(userAddress, DefaultBlockParameter.valueOf("latest")).sendAsync().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Transaction Count: "+count.getTransactionCount());
        return count.getTransactionCount().longValue();
    }

    public Long getBalance(String userAddress){
        EthGetBalance balance = new EthGetBalance();
        try {
            balance = web3j.ethGetBalance(userAddress,DefaultBlockParameter.valueOf("latest")).sendAsync().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return balance.getBalance().longValue();
    }

    public String deployContract(UserCredentials userCredentials){
        String address = "";
        try {
            DocumentHelper helper = DocumentHelper.deploy(web3j,userCredentials.getOwnerCredentials(), new DefaultGasProvider()).send();
            address= helper.getContractAddress();
            System.out.println("Contract Address: "+address);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }

}
