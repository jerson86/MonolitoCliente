package com.pragma.cliente.service;

import com.pragma.cliente.dto.ImagenDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ImagenService {
    ResponseEntity<List<ImagenDTO>> getAllImagenes();

    ResponseEntity<ImagenDTO> createImagen(ImagenDTO imagenDTO);

    ResponseEntity<ImagenDTO> updateImagen(long id, ImagenDTO imagenDTO);

    ResponseEntity<ImagenDTO> deleteImagen(long id);

    ResponseEntity<ImagenDTO> getImagenById(long id);
}
