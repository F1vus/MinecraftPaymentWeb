package net.fiv.backend.repository;

import net.fiv.backend.model.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductsDAO extends CrudRepository<Products, Long> {
}
