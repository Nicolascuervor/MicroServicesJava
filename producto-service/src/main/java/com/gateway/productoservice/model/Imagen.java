package com.gateway.productoservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Imagen {
    @Id
    @GeneratedValue
    private Long id;
    private String url;

    @ManyToOne
    private Producto producto;
}