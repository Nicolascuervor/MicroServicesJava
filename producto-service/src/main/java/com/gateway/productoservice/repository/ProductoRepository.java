package com.gateway.productoservice.repository;

import com.gateway.productoservice.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
