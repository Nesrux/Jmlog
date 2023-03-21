package com.nesrux.jmlog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.nesrux.jmlog.api.model.EntregaModel;
import com.nesrux.jmlog.api.model.in.EntregaInputModel;
import com.nesrux.jmlog.domain.model.Entrega;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaAssembler {

	private ModelMapper mapper;

	public EntregaModel toModel(Entrega entrega) {
		return mapper.map(entrega, EntregaModel.class);
	}

	public List<EntregaModel> toCollectionModel(List<Entrega> entregas) {
		return entregas.stream().map(this::toModel).collect(Collectors.toList());
	}

	public Entrega toEntity(EntregaInputModel entregaInput) {
		return mapper.map(entregaInput, Entrega.class);
	}
}
