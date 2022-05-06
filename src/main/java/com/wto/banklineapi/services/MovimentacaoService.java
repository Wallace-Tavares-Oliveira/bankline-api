package com.wto.banklineapi.services;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wto.banklineapi.dto.NovaMovimentacao;
import com.wto.banklineapi.models.Cliente;
import com.wto.banklineapi.models.Movimentacao;
import com.wto.banklineapi.models.MovimentacaoTipo;
import com.wto.banklineapi.repositories.ClienteRepository;
import com.wto.banklineapi.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void save(NovaMovimentacao novaMovimentacao) {
		Movimentacao movimentacao = new Movimentacao();

		Double valor = novaMovimentacao.getTipo()==MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
		// OR
//		Double valor = novaMovimentacao.getValor();
//		if(movimentacao.getTipo() == MovimentacaoTipo.DESPESA)
//			valor = valor * -1;
		
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		movimentacao.setTipo(novaMovimentacao.getTipo());
		movimentacao.setValor(novaMovimentacao.getValor());
		// Or
//		movimentacao.setValor(valor);
		
		Cliente cliente = clienteRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		if(cliente != null) {
			cliente.getConta().setSaldo(cliente.getConta().getSaldo() + valor);
			clienteRepository.save(cliente);
		}
		movimentacaoRepository.save(movimentacao);
	}
}
