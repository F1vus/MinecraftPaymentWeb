package net.fiv.backend.service.impl;

import net.fiv.backend.model.ProductsTable;
import net.fiv.backend.repository.ProductsDAO;
import net.fiv.backend.service.userService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsImpl implements ProductService {

    private ProductsDAO productsDAO;

    @Autowired
    public void setProductsDAO(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    @Override
    public List<ProductsTable> findAllProducts() {
        List<ProductsTable> productsTables = productsDAO.findAll();

        return productsTables.isEmpty() ? null : productsTables;
    }

}
