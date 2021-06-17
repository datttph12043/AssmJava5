package com.assm.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assm.dto.CategoriesDTO;
import com.assm.entity.Categories;


@Component
public class CategoriesMapper {
	@Autowired
	private ModelMapper mapper;
	
	//convert từ DTO về entity
	public Categories convertToEntity(CategoriesDTO categoriesDTO) {
		Categories entity = new Categories();
		mapper.map(categoriesDTO, entity);
		return entity;
	}
	
	//convert từ entity về DTO
	public CategoriesDTO convertToDTO(Categories entity) {
		CategoriesDTO categoriesDTO = new CategoriesDTO();
		mapper.map(entity, categoriesDTO);
		return categoriesDTO;
	}

}
