package com.pragma.cliente.service;

import com.pragma.cliente.dto.ClienteDTO;
import com.pragma.cliente.entity.Cliente;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    ResponseEntity<List<ClienteDTO>> getAllClientes();

    ResponseEntity<ClienteDTO> createCliente(ClienteDTO clienteDTO);

    ResponseEntity<ClienteDTO> updateCliente(long id, ClienteDTO clienteDTO);

    ResponseEntity<ClienteDTO> deleteCliente(long id);

    ResponseEntity<ClienteDTO> getClienteById(long id);

    ResponseEntity<ClienteDTO> findByTipoDocumentoAndDocumento(String tipoDocumento, String documento);
}
