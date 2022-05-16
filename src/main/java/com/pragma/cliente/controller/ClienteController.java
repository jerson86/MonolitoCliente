package com.pragma.cliente.controller;

import com.pragma.cliente.dto.ClienteDTO;
import com.pragma.cliente.entity.Cliente;
import com.pragma.cliente.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {
    @Autowired
    ClienteServiceImpl clienteService = new ClienteServiceImpl();

    @RequestMapping(value = "api/clientes", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllClientes(){
        return  clienteService.getAllClientes();
    }

    @RequestMapping(value = "api/clientes/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClienteDTO> getCliente(@PathVariable Long id){
        return clienteService.getClienteById(id);
    }

    @RequestMapping(value = "api/clientes", method = RequestMethod.POST)
    public Cliente createCliente(@RequestBody Cliente cliente){
        return clienteService.createCliente(cliente);
    }

    @RequestMapping(value = "api/clientes/{id}", method = RequestMethod.PUT)
    public Cliente updateCliente(@RequestBody Cliente cliente, @PathVariable Long id){
        return clienteService.updateCliente(id,cliente);
    }

    @RequestMapping(value = "api/clientes/{id}", method = RequestMethod.DELETE)
    public Cliente deleteCliente(@PathVariable Long id){
        return clienteService.deleteCliente(id);
    }

}
