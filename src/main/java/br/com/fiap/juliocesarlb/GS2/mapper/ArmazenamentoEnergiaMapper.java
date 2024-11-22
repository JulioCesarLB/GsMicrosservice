package br.com.fiap.juliocesarlb.GS2.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.juliocesarlb.GS2.dtos.ArmazenamentoEnergiaRequestCreateDto;
import br.com.fiap.juliocesarlb.GS2.dtos.ArmazenamentoEnergiaRequestUpdateDto;
import br.com.fiap.juliocesarlb.GS2.dtos.ArmazenamentoEnergiaResponseDto;
import br.com.fiap.juliocesarlb.GS2.model.ArmazenamentoEnergia;

@Component
public class ArmazenamentoEnergiaMapper {
	
	@Autowired
    private  ModelMapper modelMapper;

    public ArmazenamentoEnergiaResponseDto toDto(ArmazenamentoEnergia ArmazenamentoEnergia) {
        return modelMapper.map(ArmazenamentoEnergia, ArmazenamentoEnergiaResponseDto.class);
    }

    public ArmazenamentoEnergia toModel(ArmazenamentoEnergiaRequestCreateDto dto) {
        return modelMapper.map(dto, ArmazenamentoEnergia.class);
    }

    public ArmazenamentoEnergia toModel(Long id, ArmazenamentoEnergiaRequestUpdateDto dto) {
        ArmazenamentoEnergia result = modelMapper.map(dto, ArmazenamentoEnergia.class);
        result.setId(id);
        return result;
    }  
}
