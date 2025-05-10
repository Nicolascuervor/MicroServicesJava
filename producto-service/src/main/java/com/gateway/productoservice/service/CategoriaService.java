package com.gateway.productoservice.service;

import com.gateway.productoservice.model.Categoria;
import com.gateway.productoservice.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public List<Categoria> findAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Transactional
    public Optional<Categoria> findCategoriaById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Transactional
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Transactional
    public void eliminar(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new EntityNotFoundException("Categoria no encontrado con ID: " + id);
        }
        categoriaRepository.deleteById(id);
    }



}
