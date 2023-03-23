package com.nesrux.jmlog.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nesrux.jmlog.domain.model.Entrega;
import com.nesrux.jmlog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {
	private EntregaRepository entregaRepository;
	private BuscaEntregaService buscaEntregaService;

	@Transactional
	public void finalizar(Long entregaID) {
		Entrega entrega = buscaEntregaService.buscar(entregaID);
		
		entrega.finalizar();
				
		entregaRepository.save(entrega);
	}
}
