package net.fiv.backend.service.impl;

import net.fiv.backend.model.Products;
import net.fiv.backend.repository.ProductsDAO;
import net.fiv.backend.service.service.ProductsService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsImpl implements ProductsService {

    private final ProductsDAO productsDAO;

    public ProductsImpl(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    @Override
    public void save(Products products) {
        try {
            productsDAO.save(products);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("A product with this title already exists");
        }
    }

    @Override
    public List<Products> findAll() {
        return (List<Products>) productsDAO.findAll();
    }

    @Override
    public Products findById(Long id) {
        //TODO
        return null;
    }

    @Override
    public Products findByTitle(String name) {
        //TODO
        return null;
    }

    @Override
    public void deleteById(Long id) {
        //TODO
    }

    @Override
    public void deleteByTitle(String productName) {
        //TODO
    }

}
