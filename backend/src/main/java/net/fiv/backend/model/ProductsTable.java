package net.fiv.backend.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="products")
@Data
public class ProductsTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String urlimage;

    private Long price;



}
