package net.fiv.backend.service.service;

import net.fiv.backend.exception.AlreadyExistsException;
import net.fiv.backend.exception.NoSuchExistsException;
import net.fiv.backend.model.Product;
import net.fiv.backend.repository.ProductsDAO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private final ProductsDAO productsDAO;

    public ProductsService(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    public Product getProductById(long id) throws NoSuchExistsException {
        return productsDAO.findById(id)
                .orElseThrow(() -> new NoSuchExistsException("Product not found"));

    }

    public List<Product> getAllProducts() {
        return (List<Product>) productsDAO.findAll();
    }

    public Product createProduct(Product product) throws AlreadyExistsException {
        try{
            return productsDAO.save(product);
        } catch (DataIntegrityViolationException e) {
            throw new AlreadyExistsException("Product already exists");
        }
    }

}
