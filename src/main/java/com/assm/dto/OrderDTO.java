package com.assm.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.assm.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	
	@NotNull
	private Integer id;
	
	@NotNull
	private String createdate;
	
	@NotNull
	private String address;
	
	@NotNull(message = "User id không thể trống")
	private User user;
}
