package net.fiv.backend.service.service;

import net.fiv.backend.model.Products;

import java.util.List;

public interface ProductsService {

    void save(Products products);
    List<Products> findAll();
    Products findById(Long id);
    Products findByTitle(String name);
    void deleteById(Long id);
    void deleteByTitle(String productName);


}
