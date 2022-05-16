package com.pragma.cliente.repository;

import com.pragma.cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByTipoDocumentoAndDocumento(String tipoDocumento, String documento);
}
