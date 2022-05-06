package com.wto.banklineapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wto.banklineapi.models.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer>{

}
