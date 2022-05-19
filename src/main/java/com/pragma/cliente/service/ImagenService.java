package com.pragma.cliente.service;

import com.pragma.cliente.dto.ClienteDTO;
import com.pragma.cliente.dto.ImagenDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImagenService {
    ResponseEntity<List<ImagenDTO>> getAllImagenes();

    ResponseEntity<ImagenDTO> createImagen(MultipartFile foto, Long idCliente);

    ResponseEntity<ImagenDTO> updateImagen(long id, MultipartFile foto, Long idCliente);

    ResponseEntity<ImagenDTO> deleteImagen(long id);

    ResponseEntity<ImagenDTO> getImagenById(long id);

    ResponseEntity<ImagenDTO> getImagenByCliente(ClienteDTO clienteDTO);
}
