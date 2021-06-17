package com.assm.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
		//@NotNull
		private Integer id;
		
		@NotNull
		@NotBlank
		private String username;
		
		@NotNull
		@NotBlank
		@Email
		private String email;
		
		//@NotNull
		private String photo;
		
		@NotNull
		private Integer admin;
		
		@NotNull
		private Integer activated;
		
		@NotNull(message = "thiếu password")
		private String password;

}
