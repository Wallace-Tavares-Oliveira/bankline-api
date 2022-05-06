package com.wto.banklineapi.services;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wto.banklineapi.dto.NovoCliente;
import com.wto.banklineapi.models.Cliente;
import com.wto.banklineapi.models.Conta;
import com.wto.banklineapi.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public void save(NovoCliente novoCliente) {
		Cliente cliente = new Cliente();
		cliente.setCpf(novoCliente.getCpf());
		cliente.setNome(novoCliente.getNome());
		
		Conta conta =  new Conta();
		conta.setSaldo(0.0);
		conta.setNumero(new Date().getTime());
		
		cliente.setConta(conta);
		clienteRepository.save(cliente);
	}
}
