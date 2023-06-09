package com.nesrux.jmlog.domain.service;

import org.springframework.stereotype.Service;

import com.nesrux.jmlog.domain.exception.EntidadeNaoEncontradaException;
import com.nesrux.jmlog.domain.model.Entrega;
import com.nesrux.jmlog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BuscaEntregaService {
	private EntregaRepository entregaRepository;

	public Entrega buscar(Long entregaId) {
		return entregaRepository.
				findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
}
