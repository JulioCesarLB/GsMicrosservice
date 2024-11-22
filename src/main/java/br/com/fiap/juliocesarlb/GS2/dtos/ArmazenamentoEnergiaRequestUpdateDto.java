package br.com.fiap.juliocesarlb.GS2.dtos;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArmazenamentoEnergiaRequestUpdateDto {
	
	private String smartGrid;
	
	private String tipoEnergia;

	private BigDecimal quantKW;

	private String fornecedor;

	private BigDecimal valor;
}
