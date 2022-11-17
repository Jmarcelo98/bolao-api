package br.com.estudos.bolaoapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.estudos.bolaoapi.mappers.generic.GenericMapper;
import br.com.estudos.bolaoapi.model.dtos.UsuarioDTO;
import br.com.estudos.bolaoapi.model.entities.Usuario;

@Mapper
public interface UsuarioMapper extends GenericMapper<Usuario, UsuarioDTO> {

	UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

}