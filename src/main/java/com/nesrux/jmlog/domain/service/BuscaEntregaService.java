package com.nesrux.jmlog.domain.service;

import org.springframework.stereotype.Service;

import com.nesrux.jmlog.domain.exception.NegocioException;
import com.nesrux.jmlog.domain.model.Entrega;
import com.nesrux.jmlog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BuscaEntregaService {
	private EntregaRepository entregaRepository;

	public Entrega buscar(Long entregaId) {
		Entrega entrega = entregaRepository.findById(entregaId)
				.orElseThrow(() -> new NegocioException("Entrega não encontrada!"));
		return entrega;
	}
}
