package com.nesrux.jmlog.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nesrux.jmlog.domain.model.Cliente;

@RestController
public class ClienteController {
	@PersistenceContext
	private EntityManager menager;

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return menager.createQuery("from cliente", Cliente.class)
				.getResultList();
	}
}
