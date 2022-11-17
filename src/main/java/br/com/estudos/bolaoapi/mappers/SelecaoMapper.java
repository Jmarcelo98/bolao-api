package br.com.estudos.bolaoapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.estudos.bolaoapi.mappers.generic.GenericMapper;
import br.com.estudos.bolaoapi.model.dtos.SelecaoDTO;
import br.com.estudos.bolaoapi.model.entities.Selecao;

@Mapper
public interface SelecaoMapper extends GenericMapper<Selecao, SelecaoDTO> {

	SelecaoMapper INSTANCE = Mappers.getMapper(SelecaoMapper.class);

}