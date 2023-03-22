package com.nesrux.jmlog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nesrux.jmlog.api.assembler.OcorrenciaAssembler;
import com.nesrux.jmlog.api.model.OcorrenciaModel;
import com.nesrux.jmlog.api.model.in.OcorrenciaInput;
import com.nesrux.jmlog.domain.model.Entrega;
import com.nesrux.jmlog.domain.model.Ocorrencia;
import com.nesrux.jmlog.domain.service.BuscaEntregaService;
import com.nesrux.jmlog.domain.service.RegistroOcorrenciaService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
	private BuscaEntregaService buscaEntregaService;
	private RegistroOcorrenciaService registroOcorrenciaService;
	private OcorrenciaAssembler assembler;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput ocorrencia) {
		Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId, ocorrencia.getDescricao());

		return assembler.toModel(ocorrenciaRegistrada);
	}

	@GetMapping
	public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);

		return assembler.toCollectionModel(entrega.getOcorrencias());
	}
}
