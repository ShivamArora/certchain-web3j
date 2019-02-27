package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class Document {
    private String hash;
    private String title;
    private String url;
    private Entity issuer;
    private Entity receiver;
    private Date dateOfIssue;
    private String description;
}
