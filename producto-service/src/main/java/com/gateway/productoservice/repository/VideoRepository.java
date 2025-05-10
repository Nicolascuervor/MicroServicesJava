package com.gateway.productoservice.repository;

import com.gateway.productoservice.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
