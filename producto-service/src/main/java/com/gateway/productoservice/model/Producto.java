package com.gateway.productoservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


    @Column(name = "cantidad")
    private String cantidad;

    @Column(name = "origen")
    private String origen;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Imagen> imagenes;







}
