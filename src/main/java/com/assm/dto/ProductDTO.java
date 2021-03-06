package com.assm.dto;

import javax.validation.constraints.NotNull;

import com.assm.entity.Categories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	//@NotNull
	private Integer id;
	
	@NotNull(message="Thiếu name")
	private String name;
	
	@NotNull(message="Thiếu giá")
	private Integer price;
	
	private String createdate;
	
	@NotNull(message="Thiếu Trajgn thái")
	private Integer available;
	
	//@NotNull
	private String image;
	
	@NotNull(message="Thiếu id Categories")
	private Categories categorie;

}
