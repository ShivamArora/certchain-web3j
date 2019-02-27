package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TransferContract {
    String docHash;
    String issuerAddress;
    String recipientAddress;
}
