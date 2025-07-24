package net.fiv.backend.service.service;

import net.fiv.backend.exception.InsufficientFundsException;
import net.fiv.backend.model.Product;
import net.fiv.backend.model.Purchase;
import net.fiv.backend.model.User;
import net.fiv.backend.repository.PurchaseDAO;
import net.fiv.backend.repository.UserDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseService{
    private final PurchaseDAO purchaseDAO;
    private final UserDAO userDAO;

    public PurchaseService(PurchaseDAO purchaseDAO, UserDAO userDAO) {
        this.purchaseDAO = purchaseDAO;
        this.userDAO = userDAO;
    }

    @Transactional
    public void buyProduct(User customer, Product product) throws InsufficientFundsException {
        if(customer.getBalance() < product.getPrice()) {
            throw new InsufficientFundsException("Insufficient funds");
        }

        customer.setBalance(customer.getBalance() - product.getPrice());

        Purchase purchase = new Purchase();
        purchase.setProduct(product);
        purchase.setUsers(customer);

        purchaseDAO.save(purchase);
        userDAO.save(customer);
    }


}
