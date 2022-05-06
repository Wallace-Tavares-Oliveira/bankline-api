package com.wto.banklineapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wto.banklineapi.dto.NovoCliente;
import com.wto.banklineapi.models.Cliente;
import com.wto.banklineapi.repositories.ClienteRepository;
import com.wto.banklineapi.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteControler {

	// Return from clients list
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping  
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	// Save informations from clients
	@PostMapping
	public void save(@RequestBody NovoCliente cliente) {
		clienteService.save(cliente);
	}
}
