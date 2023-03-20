package com.nesrux.jmlog.domain.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nesrux.jmlog.domain.model.Cliente;
import com.nesrux.jmlog.domain.model.Entrega;
import com.nesrux.jmlog.domain.model.StatusEntraga;
import com.nesrux.jmlog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

	private EntregaRepository entregaRespository;
	private CatalogoClienteService catalogoClienteService;

	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntraga.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());

		return entregaRespository.save(entrega);
	}
}
