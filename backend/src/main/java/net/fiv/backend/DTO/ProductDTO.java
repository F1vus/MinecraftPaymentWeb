package net.fiv.backend.DTO;

import lombok.Data;

@Data
public class ProductDTO {
    private String title;
    private String description;
    private String minecraftTag;
    private Long price;
    private String image;
}
