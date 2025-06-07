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

    private String username;

    private String email;

    private String password;

    private Long balance;

    @OneToMany(mappedBy = "user")
    private Set<Purchase> purchase;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;

    public UsersMiniWallet() {

    }
}
