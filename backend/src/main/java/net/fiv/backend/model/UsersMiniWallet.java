package net.fiv.backend.model;

import jakarta.persistence.*;

import lombok.Data;



@Entity
@Table(name="users")
@Data
public class UsersMiniWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    private Long balance;
}
