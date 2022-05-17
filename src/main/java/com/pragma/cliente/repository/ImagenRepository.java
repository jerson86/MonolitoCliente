package com.pragma.cliente.repository;

import com.pragma.cliente.entity.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImagenRepository extends JpaRepository<Imagen, Long> {
    Optional<Imagen> findByIdCliente(Long idCliente);
}
