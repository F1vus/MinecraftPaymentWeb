package net.fiv.backend.model;

import jakarta.persistence.*;

import lombok.Data;

import java.util.Set;


@Entity
@Table(name="users")
@Data
public class UsersMiniWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "user")
    private Set<Purchase> purchase;

    private String username;

    private String email;

    private String password;

    private Long balance;



    public UsersMiniWallet() {

    }
}
