package com.nesrux.jmlog.domain.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nesrux.jmlog.domain.exception.NegocioException;
import com.nesrux.jmlog.domain.model.Cliente;
import com.nesrux.jmlog.domain.model.Entrega;
import com.nesrux.jmlog.domain.model.StatusEntraga;
import com.nesrux.jmlog.domain.repository.ClienteRepository;
import com.nesrux.jmlog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

	private EntregaRepository entregaRespository;
	private ClienteRepository clienteRepository;

	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = clienteRepository.findById(entrega.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente nao encontrado"));
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntraga.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());

		return entregaRespository.save(entrega);
	}
}
