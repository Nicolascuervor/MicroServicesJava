package com.gateway.productoservice.repository;

import com.gateway.productoservice.model.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenRepository extends JpaRepository<Imagen, Long> {
}
