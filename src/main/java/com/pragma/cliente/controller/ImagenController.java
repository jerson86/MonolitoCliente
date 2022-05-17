package com.pragma.cliente.controller;

import com.pragma.cliente.dto.ImagenDTO;
import com.pragma.cliente.service.ImagenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class ImagenController {

    @Autowired
    ImagenServiceImpl imagenService = new ImagenServiceImpl();
    @RequestMapping(value = "api/imagenes", method = RequestMethod.GET)
    public ResponseEntity<List<ImagenDTO>> getAllImagenes(){
        return  imagenService.getAllImagenes();
    }

    @RequestMapping(value = "api/imagenes/{id}", method = RequestMethod.GET)
    public ResponseEntity<ImagenDTO> getImagen(@PathVariable Long id){
        return imagenService.getImagenById(id);
    }

    @RequestMapping(value = "api/imagenes", method = RequestMethod.POST)
    public ResponseEntity<ImagenDTO> createCliente(@RequestBody ImagenDTO imagenDTO){
        return imagenService.createImagen(imagenDTO);
    }

    @RequestMapping(value = "api/imagenes/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ImagenDTO> updateImagen(@RequestBody ImagenDTO imagenDTO, @PathVariable Long id){
        return imagenService.updateImagen(id,imagenDTO);
    }

    @RequestMapping(value = "api/imagenes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ImagenDTO> deleteCliente(@PathVariable Long id){
        return imagenService.deleteImagen(id);
    }
}
