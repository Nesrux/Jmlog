package com.nesrux.jmlog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nesrux.jmlog.domain.model.Cliente;

@RestController
public class ClienteController {
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente(1l, "Cleiton", "cleiton@gmail.com", "1234456");
		var cliente2 = new Cliente(2l, "thiago", "thiago@gmail.com", "654321456");
		var cliente3 = new Cliente(1l, "Mercedes", "Mercedes@gmail.com", "8578584584");

		return Arrays.asList(cliente1, cliente2, cliente3);
	}
}
