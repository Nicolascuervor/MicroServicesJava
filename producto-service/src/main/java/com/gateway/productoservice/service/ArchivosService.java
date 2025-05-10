package com.gateway.productoservice.service;

import com.gateway.productoservice.model.Imagen;
import com.gateway.productoservice.model.Video;
import com.gateway.productoservice.model.Producto;
import com.gateway.productoservice.repository.ImagenRepository;
import com.gateway.productoservice.repository.VideoRepository;
import com.gateway.productoservice.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.UUID;

@Service
public class ArchivosService {

    private final Path rootLocation = Paths.get("uploads");

    @Autowired
    private ImagenRepository imagenRepository;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public void guardarImagenes(Long productoId, List<MultipartFile> archivos) throws IOException {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        for (MultipartFile archivo : archivos) {
            if (!archivo.isEmpty()) {
                String filename = UUID.randomUUID() + "_" + archivo.getOriginalFilename();
                Path destino = rootLocation.resolve(filename);
                Files.createDirectories(destino.getParent());
                Files.copy(archivo.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);

                Imagen imagen = new Imagen();
                imagen.setUrl("/uploads/" + filename); // Guarda la ruta
                imagen.setProducto(producto);
                imagenRepository.save(imagen);
            }
        }
    }

    public void guardarVideo(Long productoId, MultipartFile archivo) throws IOException {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        if (!archivo.isEmpty()) {
            String filename = UUID.randomUUID() + "_" + archivo.getOriginalFilename();
            Path destino = rootLocation.resolve(filename);
            Files.createDirectories(destino.getParent());
            Files.copy(archivo.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);

            Video video = new Video();
            video.setUrl("/uploads/" + filename);
            video.setProducto(producto);
            videoRepository.save(video);
        }
    }
}
