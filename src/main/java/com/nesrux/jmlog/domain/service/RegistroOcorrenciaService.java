package com.nesrux.jmlog.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nesrux.jmlog.domain.exception.NegocioException;
import com.nesrux.jmlog.domain.model.Entrega;
import com.nesrux.jmlog.domain.model.Ocorrencia;
import com.nesrux.jmlog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
class RegistroOcorrenciaService {
	private EntregaRepository entregaRepository;
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega = entregaRepository.findById(entregaId)
				.orElseThrow(() -> new NegocioException("Entrega não encontrada!"));
		return entrega.adicionarOcorrencia(descricao);
	}

}
