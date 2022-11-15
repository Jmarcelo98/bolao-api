package br.com.estudos.bolaoapi.mappers.generic;

import java.util.List;

public interface GenericMapper<E, DTO> {

	DTO entityToDTO(E entity);

	E DTOToEntity(DTO dto);

	List<DTO> listaEntityToListaDTO(List<E> lista);

}
