package com.pragma.cliente.dto;

import com.pragma.cliente.entity.Cliente;
import lombok.Data;

@Data
public class ImagenDTO {
    private long id;
    private String foto;
    private String fechaRegistro;
    //private long idCliente;
    private Cliente cliente;
}
