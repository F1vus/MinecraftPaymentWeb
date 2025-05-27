package net.fiv.backend.service.impl;

import net.fiv.backend.model.Products;
import net.fiv.backend.repository.ProductsDAO;
import net.fiv.backend.service.userService.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductsImpl implements ProductService {

    private final ProductsDAO productsDAO;

    public ProductsImpl(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    @Override
    public List<Products> findAllProducts() {
        List<Products> productsTables = productsDAO.findAll();

        return productsTables.isEmpty() ? null : productsTables;
    }

}
