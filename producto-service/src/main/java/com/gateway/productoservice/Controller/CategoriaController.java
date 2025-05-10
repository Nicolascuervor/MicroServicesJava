package com.gateway.productoservice.Controller;

import com.gateway.productoservice.model.Categoria;
import com.gateway.productoservice.service.CategoriaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;



@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private static final String IMAGENES_DIR = "uploads/imagenes/";

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> findAll() {
        return categoriaService.findAllCategorias();
    }

    @PostMapping
    public Categoria guardarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.guardar(categoria);
    }

    @GetMapping("/{id}")
    public Optional<Categoria> findCategoriaById(@PathVariable Long id) {
        return categoriaService.findCategoriaById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        Optional<Categoria> existente = categoriaService.findCategoriaById(id);
        if (existente.isPresent()) {
            categoria.setId(id);
            Categoria actualizado = categoriaService.guardar(categoria);
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarCategoria(@PathVariable Long id) {
        try {
            categoriaService.eliminar(id);
            return new ResponseEntity<>(Map.of("eliminado", true), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
