package helpers;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class UserCredentials {
    private static UserCredentials userCredentials;
    private static UserCredentials ownerUserCredentials;
    private static Credentials credentials;
    private static Credentials ownerCredentials;

    public static UserCredentials loadOwner(String privateKey) {
        ownerCredentials = Credentials.create(privateKey);
        ownerUserCredentials = new UserCredentials();
        return ownerUserCredentials;
    }

    public static UserCredentials load(String password, File walletFile) {
        try {
            credentials = WalletUtils.loadCredentials(password, walletFile);
            System.out.println("Loaded Address: "+credentials.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        }
        userCredentials = new UserCredentials();
        return userCredentials;
    }

    public static String createNewWallet(String password, Path location) {
        String walletFileName = "";
        System.out.println("Creation Time Password: "+password);
        System.out.println("Wallet File Source: "+location);
        try {
            walletFileName = WalletUtils.generateNewWalletFile(password, location.toFile(), false);
            System.out.println("Generated File Name: " + walletFileName);
        } catch (CipherException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        return walletFileName;
    }

    public Credentials getOwnerCredentials() {
        return ownerCredentials;
    }

    public Credentials getCredentials(){
        return credentials;
    }

    public String getPublicAddress(){
        return credentials.getAddress();
    }

    public static UserCredentials getCurrentUserCredentials(){
        System.out.println("Current User Address: "+userCredentials.getPublicAddress());
        return userCredentials;
    }

    public static void setUserCredentials(UserCredentials uc){
        userCredentials = uc;
        credentials = uc.getCredentials();
    }


    public String getOwnerPublicAddress(){
        return ownerCredentials.getAddress();
    }
}
