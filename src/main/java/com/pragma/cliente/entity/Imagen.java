package com.pragma.cliente.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "imagenes")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String foto;
    private String fechaRegistro;
    private long idCliente;
}
