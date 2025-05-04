package net.fiv.backend.service.userwallet;

import net.fiv.backend.model.UsersMiniWallet;
import net.fiv.backend.repository.UserMiniWalletDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserMiniWalletService {

    private final UserMiniWalletDAO walletDAO;

    @Autowired
    public UserMiniWalletService(UserMiniWalletDAO walletDAO) {
        this.walletDAO = walletDAO;
    }

    public UsersMiniWallet saveWallet(UsersMiniWallet wallet) {
        return walletDAO.save(wallet);
    }

    public Optional<UsersMiniWallet> findById(Integer id) {
        return walletDAO.findById(id);
    }

    public Iterable<UsersMiniWallet> findAll() {
        return walletDAO.findAll();
    }

    public void deleteById(Integer id) {
        walletDAO.deleteById(id);
    }

    // inne metody biznesowe
}