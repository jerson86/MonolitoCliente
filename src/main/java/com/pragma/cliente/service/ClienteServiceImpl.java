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

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;
    private Message message;
    private ModelMapper modelMapper;
    @Override
    public ResponseEntity<Object> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        if(clientes.isEmpty()){
            return new ResponseEntity<>(new Message(HttpStatus.NOT_FOUND,"No hay registros", "No hay clientes registrados"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(long id, Cliente clienteUpd) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("cliente",id));
        cliente.setId(id);
        cliente.setNombres(clienteUpd.getNombres());
        cliente.setApellidos(clienteUpd.getApellidos());
        //cliente.setTipoDocumento(clienteUpd.getTipoDocumento());
        //cliente.setDocumento(clienteUpd.getDocumento());
        cliente.setEdad(clienteUpd.getEdad());
        cliente.setCiudadNacimiento(clienteUpd.getCiudadNacimiento());
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente deleteCliente(long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("cliente",id));
        clienteRepository.delete(cliente);
        return cliente;
    }

    @Override
    public ResponseEntity<ClienteDTO> getClienteById(long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("cliente",id));

        // convert entity to DTO
        ClienteDTO clienteResponse = modelMapper.map(cliente, ClienteDTO.class);
        System.out.println(clienteResponse.toString());
        return ResponseEntity.ok().body(clienteResponse);
    }

    @Override
    public List<Cliente> findByTipoDocumentoAndDocumento(String tipoDocumento, String documento) {
        return clienteRepository.findByTipoDocumentoAndDocumento(tipoDocumento, documento);
    }
}
