package br.com.fiap.juliocesarlb.GS2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.juliocesarlb.GS2.model.ArmazenamentoEnergia;
import br.com.fiap.juliocesarlb.GS2.repository.ArmazenamentoEnergiaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArmazenamentoEnergiaService {
	
	@Autowired
	private ArmazenamentoEnergiaRepository repository;

	public List<ArmazenamentoEnergia> list() {
		return repository.findAll();
	}

	public ArmazenamentoEnergia save(ArmazenamentoEnergia ArmazenamentoEnergia) {
		return repository.save(ArmazenamentoEnergia);
	}

	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Optional<ArmazenamentoEnergia> findById(Long id) {
		return repository.findById(id);
	}

}
