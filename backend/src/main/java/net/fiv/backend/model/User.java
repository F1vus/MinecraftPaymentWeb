package net.fiv.backend.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.*;


@Entity
@Data
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @ColumnDefault("0")
    private Long balance;

    @OneToMany(mappedBy = "users")
    private List<Purchase> purchaseList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_role",
            joinColumns = {
                    @JoinColumn(name = "users_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "roles_id") })
    private Collection<Role> roles = new HashSet<>();
}
