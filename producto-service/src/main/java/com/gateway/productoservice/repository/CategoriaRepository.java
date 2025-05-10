package com.gateway.productoservice.repository;

import com.gateway.productoservice.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
