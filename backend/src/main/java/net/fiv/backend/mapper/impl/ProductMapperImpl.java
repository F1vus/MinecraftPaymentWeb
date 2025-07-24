package net.fiv.backend.mapper.impl;

import net.fiv.backend.DTO.ProductDTO;
import net.fiv.backend.mapper.Mapper;
import net.fiv.backend.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements Mapper<Product, ProductDTO> {

    private final ModelMapper modelMapper;

    public ProductMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDTO mapTo(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public Product mapFrom(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }
}
