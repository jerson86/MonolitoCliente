package com.pragma.cliente.service;

import com.pragma.cliente.dto.ClienteDTO;
import com.pragma.cliente.entity.Cliente;
import com.pragma.cliente.exception.ResourceNotFoundException;
import com.pragma.cliente.repository.ClienteRepository;
import com.pragma.cliente.util.Message;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        clientes.stream().findFirst().orElseThrow(()->
                new ResourceNotFoundException("cliente",1L)
        );
        // convert entity to DTO
        List<ClienteDTO> clienteDTOS= new ArrayList<>();
        clientes.forEach(cliente -> {
            ClienteDTO clienteResponse = modelMapper.map(cliente, ClienteDTO.class);
            clienteDTOS.add(clienteResponse);
        });

        return ResponseEntity.ok().body(clienteDTOS);
    }

    @Override
    public ResponseEntity<ClienteDTO> createCliente(ClienteDTO clienteDTO) {
        // convert DTO to Entity
        Cliente clienteRequest = modelMapper.map(clienteDTO, Cliente.class);
        clienteRepository.save(clienteRequest);
        // convert entity to DTO
        ClienteDTO clienteResponse = modelMapper.map(clienteRequest, ClienteDTO.class);
        return ResponseEntity.ok().body(clienteResponse);
    }

    @Override
    public ResponseEntity<ClienteDTO> updateCliente(long id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("cliente",id));
        // convert DTO to Entity
        Cliente clienteRequest = modelMapper.map(clienteDTO, Cliente.class);
        cliente.setId(id);
        cliente.setNombres(clienteRequest.getNombres());
        cliente.setApellidos(clienteRequest.getApellidos());
        cliente.setEdad(clienteRequest.getEdad());
        cliente.setCiudadNacimiento(clienteRequest.getCiudadNacimiento());
        clienteRepository.save(cliente);
        // convert entity to DTO
        ClienteDTO clienteResponse = modelMapper.map(cliente, ClienteDTO.class);

        return ResponseEntity.ok().body(clienteResponse);
    }

    @Override
    public ResponseEntity<ClienteDTO> deleteCliente(long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("cliente",id));
        clienteRepository.delete(cliente);
        // convert entity to DTO
        ClienteDTO clienteResponse = modelMapper.map(cliente, ClienteDTO.class);
        return ResponseEntity.ok().body(clienteResponse);
    }

    @Override
    public ResponseEntity<ClienteDTO> getClienteById(long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("cliente",id));

        // convert entity to DTO
        ClienteDTO clienteResponse = modelMapper.map(cliente, ClienteDTO.class);
        return ResponseEntity.ok().body(clienteResponse);
    }

    @Override
    public ResponseEntity<ClienteDTO> findByTipoDocumentoAndDocumento(String tipoDocumento, String documento) {
        Cliente cliente = clienteRepository.findByTipoDocumentoAndDocumento(tipoDocumento, documento).orElseThrow(()-> new ResourceNotFoundException("cliente",1L));
        // convert entity to DTO
        ClienteDTO clienteResponse = modelMapper.map(cliente, ClienteDTO.class);
        return ResponseEntity.ok().body(clienteResponse);
    }
}
