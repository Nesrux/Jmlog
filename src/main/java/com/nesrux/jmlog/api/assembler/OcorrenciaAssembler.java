package com.nesrux.jmlog.api.assembler;

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

}
