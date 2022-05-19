package com.pragma.cliente.service;


import com.pragma.cliente.dto.ClienteDTO;
import com.pragma.cliente.dto.ImagenDTO;
import com.pragma.cliente.entity.Cliente;
import com.pragma.cliente.entity.Imagen;
import com.pragma.cliente.exception.ResourceNotFoundException;
import com.pragma.cliente.repository.ClienteRepository;
import com.pragma.cliente.repository.ImagenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImagenServiceImpl implements ImagenService{
    @Autowired
    private ImagenRepository imagenRepository;
    @Autowired
    private ClienteRepository clienteRepository;
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
    public ResponseEntity<ImagenDTO> createImagen(MultipartFile foto, Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(()-> new ResourceNotFoundException("cliente",idCliente));

        ImagenDTO imagenDTO = new ImagenDTO();
        imagenDTO.setCliente(cliente);
        imagenDTO.setFoto(foto.getOriginalFilename());
        // convert DTO to Entity
        Imagen imagenRequest = modelMapper.map(imagenDTO, Imagen.class);
        imagenRepository.save(imagenRequest);
        // convert entity to DTO
        ImagenDTO imagenResponse = modelMapper.map(imagenRequest, ImagenDTO.class);
        return ResponseEntity.ok().body(imagenResponse);
    }

    @Override
    public ResponseEntity<ImagenDTO> updateImagen(long id, MultipartFile foto, Long idCliente) {
        Imagen imagen = imagenRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("imagen",id));
        //ImagenDTO imagenDTO = new ImagenDTO();
        //imagen.setIdCliente(idCliente);
        imagen.setFoto(foto.getOriginalFilename());
        imagen.setId(id);

        imagenRepository.save(imagen);
        // convert entity to DTO
        ImagenDTO imagenResponse = modelMapper.map(imagen, ImagenDTO.class);

        return ResponseEntity.ok().body(imagenResponse);
    }

    @Override
    public ResponseEntity<ImagenDTO> deleteImagen(long id) {
        Imagen imagen = imagenRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("imagen",id));
        imagenRepository.delete(imagen);
        // convert entity to DTO
        ImagenDTO imagenResponse = modelMapper.map(imagen, ImagenDTO.class);
        return ResponseEntity.ok().body(imagenResponse);
    }

    @Override
    public ResponseEntity<ImagenDTO> getImagenById(long id) {
        Imagen imagen = imagenRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("imagen",id));

        // convert entity to DTO
        ImagenDTO imagenResponse = modelMapper.map(imagen, ImagenDTO.class);
        return ResponseEntity.ok().body(imagenResponse);
    }

    @Override
    public ResponseEntity<ImagenDTO> getImagenByCliente(ClienteDTO clienteDTO) {
        Imagen imagen = imagenRepository.findByCliente(clienteDTO).orElseThrow(()-> new ResourceNotFoundException("imagen",clienteDTO.getId()));

        // convert entity to DTO
        ImagenDTO imagenResponse = modelMapper.map(imagen, ImagenDTO.class);
        return ResponseEntity.ok().body(imagenResponse);
    }

}
