package com.shopezly.dto;

import com.shopezly.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDTO {

	@Email(message = "Invalid Email format")
	@NotNull(message = "Email is mandatory!")
	private String email;

	@NotNull(message = "Password is mandatory!")
	@NotBlank(message = "Password cannot be blank!")
	@NotEmpty(message = "Password cannot be empty!")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", 
	message = "password must contain minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character")
	private String password;
	
	@NotNull(message = "choose between ADMIN or CUSTOMER")
	private Role role;
	
}
