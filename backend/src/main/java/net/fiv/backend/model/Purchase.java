package net.fiv.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Table(name="purchase")
@Data
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersMiniWallet user;

    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

    public Purchase() {}
}
