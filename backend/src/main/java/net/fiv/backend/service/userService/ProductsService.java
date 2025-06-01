package net.fiv.backend.service.userService;

import net.fiv.backend.model.Products;
import net.fiv.backend.repository.ProductsDAO;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {

    private final ProductsDAO productsDAO;

    public ProductsService(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    public void save(Products products) {
        productsDAO.save(products);
    }

    public List<Products> findAll() {
        List<Products> productsList = new ArrayList<>();
        Streamable.of(productsDAO.findAll()).forEach(productsList::add);
        return productsList;
    }

}
