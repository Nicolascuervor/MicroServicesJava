package com.gateway.productoservice.Controller;

import com.gateway.productoservice.service.ArchivosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
@RequestMapping("/api")
public class ArchivosController {

    @Autowired
    private ArchivosService archivosService;

    @PostMapping("/productos/{id}/imagenes")
    public ResponseEntity<?> subirImagenes(@PathVariable Long id, @RequestParam("imagenes") List<MultipartFile> imagenes) {
        try {
            archivosService.guardarImagenes(id, imagenes);
            return ResponseEntity.ok("Imágenes subidas");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al subir imágenes: " + e.getMessage());
        }
    }

    @PostMapping("/productos/{id}/video")
    public ResponseEntity<?> subirVideo(@PathVariable Long id, @RequestParam("video") MultipartFile video) {
        try {
            archivosService.guardarVideo(id, video);
            return ResponseEntity.ok("Video subido");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al subir video: " + e.getMessage());
        }
    }
}
