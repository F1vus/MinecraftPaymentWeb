package net.fiv.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name="purchase")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User users;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Product product;

    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

}
