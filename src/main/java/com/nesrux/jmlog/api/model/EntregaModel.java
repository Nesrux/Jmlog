package com.nesrux.jmlog.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.nesrux.jmlog.domain.model.StatusEntraga;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaModel {

	private Long id;
	private String nomeCliente;
	private DestinatarioModel destinatario;
	private BigDecimal taxa;
	private StatusEntraga status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacap;

}
