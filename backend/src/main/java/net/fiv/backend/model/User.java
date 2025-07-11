package net.fiv.backend.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    private Long balance;

    @OneToMany(mappedBy = "users")
    private Set<Purchase> purchase;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_role",
            joinColumns = {
                    @JoinColumn(name = "users_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "roles_id") })
    private Collection<Role> roles = new HashSet<>();

    public Collection<Role> getRoles() {
        return new HashSet<>(roles);
    }
}
