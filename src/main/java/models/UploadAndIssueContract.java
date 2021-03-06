package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor@Data
public class UploadAndIssueContract {
    Document document;
    TransferContract transferContract;
}
