package br.com.fiap.juliocesarlb.GS2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.juliocesarlb.GS2.model.ArmazenamentoEnergia;

@Repository
public interface ArmazenamentoEnergiaRepository extends JpaRepository<ArmazenamentoEnergia, Long> {
	
}
