package com.wto.banklineapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wto.banklineapi.dto.NovaMovimentacao;
import com.wto.banklineapi.models.Movimentacao;
import com.wto.banklineapi.repositories.MovimentacaoRepository;
import com.wto.banklineapi.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoControler {

	// Return from clients list
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	@Autowired
	MovimentacaoService movimentacaoService;
	
	@GetMapping  
	public List<Movimentacao> findAll() {
		return movimentacaoRepository.findAll();
	}
	
	// Save informations from clients
	@PostMapping
	public void save(@RequestBody NovaMovimentacao movimentacao) {
		movimentacaoService.save(movimentacao);
	}
}
