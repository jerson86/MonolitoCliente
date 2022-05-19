package com.pragma.cliente.service;

import com.pragma.cliente.dto.ClienteDTO;
import com.pragma.cliente.dto.ImagenMongoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImagenMongoService {
    ResponseEntity<List<ImagenMongoDTO>> getAllImagenes();

    ResponseEntity<ImagenMongoDTO> createImagen(MultipartFile foto, Long idCliente) throws IOException;

    ResponseEntity<ImagenMongoDTO> updateImagen(String id, MultipartFile foto, Long idCliente);

    ResponseEntity<ImagenMongoDTO> deleteImagen(String id);

    ResponseEntity<ImagenMongoDTO> getImagenById(String id);

    ResponseEntity<ImagenMongoDTO> getImagenByCliente(ClienteDTO clienteDTO);
}
