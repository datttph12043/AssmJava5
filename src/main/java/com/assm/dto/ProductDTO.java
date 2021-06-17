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
	// @NotNull
	private Integer id;

	@NotNull(message = "Thiếu name")
	private String name;

	@NotNull(message = "Thiếu giá")
	private Integer price;

	private String createdate;

	@NotNull(message = "Thiếu Trajgn thái")
	private Integer available;

	// @NotNull
	private String image;

	private Integer quantity;

	@NotNull(message = "Thiếu id Categories")
	private Categories categorie;

	public ProductDTO(Integer id, @NotNull(message = "Thiếu name") String name,
			@NotNull(message = "Thiếu giá") Integer price, String createdate,
			@NotNull(message = "Thiếu Trajgn thái") Integer available) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.createdate = createdate;
		this.available = available;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", price=" + price + ", available=" + available
				+ ", quantity=" + quantity + "]";
	}

}
