package com.pragma.cliente.controller;

import com.pragma.cliente.dto.ImagenDTO;
import com.pragma.cliente.service.ImagenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
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

    @RequestMapping(value = "api/imagenes/{id}/{idCliente}", method = RequestMethod.GET)
    public ResponseEntity<ImagenDTO> getImagenByIdCliente(@PathVariable Long idCliente){
        return imagenService.getImagenByIdCliente(idCliente);
    }

    @RequestMapping(value = "api/imagenes/{idCliente}", method = RequestMethod.POST)
    public ResponseEntity<ImagenDTO> createCliente(@RequestParam("foto") MultipartFile foto, @PathVariable Long idCliente){
        return imagenService.createImagen(foto,idCliente);
    }

    @RequestMapping(value = "api/imagenes/{id}/{idCliente}", method = RequestMethod.PUT)
    public ResponseEntity<ImagenDTO> updateImagen(@RequestParam("foto") MultipartFile foto, @PathVariable Long idCliente, @PathVariable Long id){
        return imagenService.updateImagen(id, foto, idCliente);
    }

    @RequestMapping(value = "api/imagenes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ImagenDTO> deleteCliente(@PathVariable Long id){
        return imagenService.deleteImagen(id);
    }
}
