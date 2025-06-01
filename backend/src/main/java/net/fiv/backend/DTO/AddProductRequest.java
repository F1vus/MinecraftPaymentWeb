package net.fiv.backend.DTO;

import lombok.Data;

@Data
public class AddProductRequest {
    String title;
    String description;
    String minecraftTag;
    Long price;
    String urlimage;
}
