package net.fiv.backend.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "user_mini_wallet")
public class UsersMiniWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private long balance;

    public UsersMiniWallet(String username, long balance) {
        this.username = username;
        this.balance = balance;
    }


    public UsersMiniWallet() {

    }
}
