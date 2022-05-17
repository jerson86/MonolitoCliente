package com.pragma.cliente.service;


import com.pragma.cliente.dto.ImagenDTO;
import com.pragma.cliente.entity.Imagen;
import com.pragma.cliente.exception.ResourceNotFoundException;
import com.pragma.cliente.repository.ImagenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class ImagenServiceImpl implements ImagenService{
    @Autowired
    private ImagenRepository imagenRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<List<ImagenDTO>> getAllImagenes() {
        List<Imagen> imagenes = imagenRepository.findAll();
        imagenes.stream().findFirst().orElseThrow(()->
                new ResourceNotFoundException("imagen",1L)
        );
        // convert entity to DTO
        List<ImagenDTO> imagenDTOS= new ArrayList<>();
        imagenes.forEach(imagen -> {
            ImagenDTO imagenResponse = modelMapper.map(imagen, ImagenDTO.class);
            imagenDTOS.add(imagenResponse);
        });

        return ResponseEntity.ok().body(imagenDTOS);
    }

    @Override
    public ResponseEntity<ImagenDTO> createImagen(ImagenDTO imagenDTO) {
        // convert DTO to Entity
        Imagen imagenRequest = modelMapper.map(imagenDTO, Imagen.class);
        imagenRepository.save(imagenRequest);
        // convert entity to DTO
        ImagenDTO imagenResponse = modelMapper.map(imagenRequest, ImagenDTO.class);
        return ResponseEntity.ok().body(imagenResponse);
    }

    @Override
    public ResponseEntity<ImagenDTO> updateImagen(long id, ImagenDTO imagenDTO) {
        Imagen imagen = imagenRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("cliente",id));
        // convert DTO to Entity
        Imagen imagenRequest = modelMapper.map(imagenDTO, Imagen.class);
        imagenRepository.save(imagen);
        // convert entity to DTO
        ImagenDTO imagenResponse = modelMapper.map(imagen, ImagenDTO.class);

        return ResponseEntity.ok().body(imagenResponse);
    }

    @Override
    public ResponseEntity<ImagenDTO> deleteImagen(long id) {
        Imagen imagen = imagenRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("cliente",id));
        imagenRepository.delete(imagen);
        // convert entity to DTO
        ImagenDTO imagenResponse = modelMapper.map(imagen, ImagenDTO.class);
        return ResponseEntity.ok().body(imagenResponse);
    }

    @Override
    public ResponseEntity<ImagenDTO> getImagenById(long id) {
        Imagen imagen = imagenRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("cliente",id));

        // convert entity to DTO
        ImagenDTO imagenResponse = modelMapper.map(imagen, ImagenDTO.class);
        return ResponseEntity.ok().body(imagenResponse);
    }
}
