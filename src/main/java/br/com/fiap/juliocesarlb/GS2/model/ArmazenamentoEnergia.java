package br.com.fiap.juliocesarlb.GS2.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class ArmazenamentoEnergia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length =50)
	private String tipoEnergia;
	
	@Column (precision = 20, scale=2)
	private BigDecimal quantKW;
	
	@Column(nullable = false, length =100)
	private String fornecedor;
	
	@Column (precision = 16, scale=2)
	private BigDecimal valor;
}
