package com.wto.banklineapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wto.banklineapi.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
