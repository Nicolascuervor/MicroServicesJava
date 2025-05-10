package com.gateway.productoservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Video {
    @Id
    @GeneratedValue
    private Long id;
    private String url;

    @OneToOne
    private Producto producto;
}