package net.fiv.backend.DTO;

import lombok.Data;

@Data
public class AddProductRequest {
    String title;
    String description;
    String minecraft_tag;
    Long price;
    String urlimage;
}
