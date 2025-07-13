package net.fiv.backend.mapper;

import net.fiv.backend.DTO.ProductsDTO;
import net.fiv.backend.model.Products;

public class ProductsMapper {

    public static Products toProducts(ProductsDTO dto) {
        Products products = new Products();

        products.setTitle(dto.getTitle());
        products.setDescription(dto.getDescription());
        products.setUrlimage(dto.getUrlimage());
        products.setMinecraftTag(dto.getMinecraftTag());
        products.setPrice(dto.getPrice());

        return products;
    }

    public static ProductsDTO toProductsDTO(Products products) {
        ProductsDTO dto = new ProductsDTO();

        dto.setTitle(products.getTitle());
        dto.setDescription(products.getDescription());
        dto.setUrlimage(products.getUrlimage());
        dto.setMinecraftTag(products.getMinecraftTag());
        dto.setPrice(products.getPrice());

        return dto;
    }

}
