package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Entity {
    private String name;
    private String website;
    private String address;
    private String blockchainAddress;
}
