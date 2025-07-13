package net.fiv.backend.service.impl;

import net.fiv.backend.DTO.ProductsDTO;
import net.fiv.backend.mapper.ProductsMapper;
import net.fiv.backend.model.Products;
import net.fiv.backend.repository.ProductsDAO;
import net.fiv.backend.service.service.ProductsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductsDAO productsDAO;

    public ProductsServiceImpl(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
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

    public List<ProductsDTO> getAllProducts() {
        List<Products> products = (List<Products>) productsDAO.findAll();
        return products.stream()
                .map(ProductsMapper::toProductsDTO)
                .collect(Collectors.toList());
    }

    public ProductsDTO createProduct(ProductsDTO productsDTO) {
        Products products = ProductsMapper.toProducts(productsDTO);
        productsDAO.save(products);
        return ProductsMapper.toProductsDTO(products);
    }

}
