package com.pragma.cliente.repository;

import com.pragma.cliente.entity.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenRepository extends JpaRepository<Imagen, Long> {
}
