package br.com.fiap.juliocesarlb.GS2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.juliocesarlb.GS2.dtos.ArmazenamentoEnergiaRequestCreateDto;
import br.com.fiap.juliocesarlb.GS2.dtos.ArmazenamentoEnergiaRequestUpdateDto;
import br.com.fiap.juliocesarlb.GS2.dtos.ArmazenamentoEnergiaResponseDto;
import br.com.fiap.juliocesarlb.GS2.mapper.ArmazenamentoEnergiaMapper;
import br.com.fiap.juliocesarlb.GS2.service.ArmazenamentoEnergiaService;
import br.com.fiap.juliocesarlb.GS2.views.ArmazenamentoEnergiaViewType;
import lombok.RequiredArgsConstructor;



/*
 * Armazenamento e Distribuição de Energia: Inovações em tecnologias de armazenamento de
energia para garantir uma oferta contínua de energia renovável. Soluções para uma distribuição
de energia mais eficiente, incluindo smart grids e gestão integrada da rede elétrica. 
 * 
 * */

@RestController
@RequestMapping("/armazenEnergia")
@RequiredArgsConstructor
public class ArmazenamentoDeEnergiaController {
	@Autowired
	private ArmazenamentoEnergiaService service;
	@Autowired
	private ArmazenamentoEnergiaMapper mapper;
	private ArmazenamentoEnergiaMapper repository;
	
	@GetMapping
	public ResponseEntity<List<ArmazenamentoEnergiaResponseDto>> list() {
		List<ArmazenamentoEnergiaResponseDto> dto = service.list()
	            .stream()
	            .map(e -> mapper.toDto(e))
	            .toList();
	        
	        return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ArmazenamentoEnergiaResponseDto> findById(@PathVariable Long id) {
		return ResponseEntity.ok()
    			.body(
    					service
    					.findById(id)
    					.map(e -> mapper.toDto(e))
    					.orElseThrow(() -> new RuntimeException("Id inexistente"))
    			);  

	}

	@GetMapping("/find")
	public ResponseEntity<?> findByNome(@RequestParam String nome, ArmazenamentoEnergiaViewType type) {
		 switch (type) {
         case VALUES:
            // return ResponseEntity.ok().body(repository.findAllByNomeContains(nome, ProdutoFullView.class));                
         case INFORMATION:
            // return ResponseEntity.ok().body(repository.findAllByNomeContains(nome, ProdutoSimpleView.class));            
     }
     return ResponseEntity.noContent().build();

	}
	

	@PostMapping
	public ResponseEntity<ArmazenamentoEnergiaResponseDto> create(@RequestBody ArmazenamentoEnergiaRequestCreateDto dto) {
		return ResponseEntity
        		.status(HttpStatus.CREATED)
        		.body(
        			mapper.toDto(
        					service.save(mapper.toModel(dto)))
        			);

	}

	@PutMapping("{id}")
	public ResponseEntity<ArmazenamentoEnergiaResponseDto> update(@PathVariable Long id, @RequestBody ArmazenamentoEnergiaRequestUpdateDto dto) {
		 if (! service.existsById(id)){
	            throw new RuntimeException("Id inexistente");
	        }                
	        return ResponseEntity.ok()
	        		.body(
	        			mapper.toDto(
	        				service.save(mapper.toModel(id, dto)))
	        		);

	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		 if (! service.existsById(id)){
	        	throw new RuntimeException("Id inexistente");
	        }

	        service.delete(id);

	}

	

}
