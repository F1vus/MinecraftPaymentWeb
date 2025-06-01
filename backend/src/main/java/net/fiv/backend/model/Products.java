package net.fiv.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="products")
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String description;

    private String urlimage;

    private String minecraftTag;

    private Long price;

    public Products() {

    }
}
