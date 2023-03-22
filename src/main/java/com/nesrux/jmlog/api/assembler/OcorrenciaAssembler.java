package com.nesrux.jmlog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.nesrux.jmlog.api.model.OcorrenciaModel;
import com.nesrux.jmlog.domain.model.Ocorrencia;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {
	private ModelMapper mapper;

	public OcorrenciaModel toModel(Ocorrencia ocorrencia) {
		return mapper.map(ocorrencia, OcorrenciaModel.class);
	}

	public List<OcorrenciaModel> toCollectionModel(List<Ocorrencia> ocorrencias) {
		return ocorrencias.stream().map(this::toModel).collect(Collectors.toList());
	}
}
