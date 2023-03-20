package com.nesrux.jmlog.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nesrux.jmlog.domain.exception.NegocioException;
import com.nesrux.jmlog.domain.model.Cliente;
import com.nesrux.jmlog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CatalogoClienteService {

private ClienteRepository clienteRepository;
	
	public Cliente buscar(Long clienteId) {
		return clienteRepository.findById(clienteId)
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if (emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
	
}
