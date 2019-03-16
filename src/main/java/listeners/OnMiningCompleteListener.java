package listeners;

public interface OnMiningCompleteListener {
    void onTransactionComplete(String transactionHash,String documentHash);
    void onTransactionError(String message);
}
