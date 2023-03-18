package com.nesrux.jmlog.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nesrux.jmlog.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findByNome(String nome);
	List<Cliente> findByNomeContaining(String nome);
}
