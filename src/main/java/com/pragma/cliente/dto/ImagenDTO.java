package com.pragma.cliente.dto;

import lombok.Data;

@Data
public class ImagenDTO {
    private long id;
    private String foto;
    private String fechaRegistro;
    private long idCliente;
}
