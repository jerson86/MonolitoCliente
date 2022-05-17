package com.pragma.cliente.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@Table(name = "imagenes")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String foto;
    @CreationTimestamp
    private Instant fechaRegistro;
    private long idCliente;
    //@OneToOne
    //@JoinColumn(name = "idCliente", nullable = false)
    //private Cliente cliente;
}
