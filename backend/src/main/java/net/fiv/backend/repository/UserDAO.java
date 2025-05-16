package net.fiv.backend.repository;

import net.fiv.backend.model.UsersMiniWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<UsersMiniWallet, Long> {

    Optional<UsersMiniWallet> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
