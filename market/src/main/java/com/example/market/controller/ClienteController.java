package com.example.market.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.domain.dto.ClienteDTO;
import com.example.market.domain.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> getAll() {
        return clienteService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ClienteDTO> getCliente(@PathVariable("id") Long id) {
        return clienteService.getCliente(id);
    }

    @PostMapping
    public ClienteDTO save(@RequestBody ClienteDTO cliente) {
        return clienteService.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        clienteService.delete(id);
    }
}
