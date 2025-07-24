package net.fiv.backend.repository;

import net.fiv.backend.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseDAO extends JpaRepository<Purchase, Long> {
}
