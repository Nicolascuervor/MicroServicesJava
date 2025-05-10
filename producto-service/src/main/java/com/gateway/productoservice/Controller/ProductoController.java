package com.gateway.productoservice.Controller;

import com.gateway.productoservice.model.Producto;
import com.gateway.productoservice.service.ProductoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private static final String IMAGENES_DIR = "uploads/imagenes/";
    private static final String VIDEOS_DIR = "uploads/videos/";

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> findAll() {
        return productoService.findAllProductos();
    }

    @PostMapping("/crear")
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    @GetMapping("/{id}")
    public Optional<Producto> findProductoById(@PathVariable Long id) {
        return productoService.findProductoById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Optional<Producto> existente = productoService.findProductoById(id);
        if (existente.isPresent()) {
            producto.setId(id);
            Producto actualizado = productoService.guardar(producto);
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable Long id) {
        try {
            productoService.eliminar(id);
            return new ResponseEntity<>(Map.of("eliminado", true), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
