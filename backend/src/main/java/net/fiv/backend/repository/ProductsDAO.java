package net.fiv.backend.repository;

import net.fiv.backend.model.ProductsTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsDAO extends JpaRepository<ProductsTable, Long> {

    List<ProductsTable> findAllProducts(Long productId);

}
