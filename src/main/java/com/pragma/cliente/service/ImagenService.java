package com.pragma.cliente.service;

import com.pragma.cliente.dto.ClienteDTO;
import org.springframework.http.ResponseEntity;

public interface ImagenService {
    ResponseEntity<Object> getAllClientes();

    ResponseEntity<ClienteDTO> createCliente(ClienteDTO clienteDTO);

    ResponseEntity<ClienteDTO> updateCliente(long id, ClienteDTO clienteDTO);

    ResponseEntity<ClienteDTO> deleteCliente(long id);

    ResponseEntity<ClienteDTO> getClienteById(long id);
}
