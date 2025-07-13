package net.fiv.backend.service.service;

import net.fiv.backend.DTO.ProductsDTO;
import net.fiv.backend.model.Products;

import java.util.List;

public interface ProductsService {

    List<ProductsDTO> getAllProducts();
    ProductsDTO createProduct(ProductsDTO productsDTO);
    Products findById(Long id);
    Products findByTitle(String name);
    void deleteById(Long id);
    void deleteByTitle(String productName);


}
