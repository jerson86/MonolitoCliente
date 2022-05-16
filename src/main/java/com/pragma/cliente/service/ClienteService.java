package com.pragma.cliente.service;

import com.pragma.cliente.dto.ClienteDTO;
import com.pragma.cliente.entity.Cliente;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    ResponseEntity<Object> getAllClientes();

    Cliente createCliente(Cliente cliente);

    Cliente updateCliente(long id, Cliente cliente);

    Cliente deleteCliente(long id);

    ResponseEntity<ClienteDTO> getClienteById(long id);

    List<Cliente> findByTipoDocumentoAndDocumento(String tipoDocumento, String documento);
}
