package net.fiv.backend.model;

import jakarta.persistence.*;

import lombok.Getter;


@Getter
@Entity
@Table(name = "user_mini_wallet")
public class UsersMiniWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private long balance;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UsersMiniWallet(String username, long balance) {
        this.username = username;
        this.balance = balance;
    }


    public UsersMiniWallet() {

    }
}
