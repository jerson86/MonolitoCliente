package com.pragma.cliente.service;

import com.pragma.cliente.dto.ClienteDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteService {
    ResponseEntity<List<ClienteDTO>> getAllClientes();

    ResponseEntity<ClienteDTO> createCliente(ClienteDTO clienteDTO);

    ResponseEntity<ClienteDTO> updateCliente(long id, ClienteDTO clienteDTO);

    ResponseEntity<ClienteDTO> deleteCliente(long id);

    ResponseEntity<ClienteDTO> getClienteById(long id);

    ResponseEntity<ClienteDTO> findByTipoDocumentoAndDocumento(String tipoDocumento, String documento);
}
