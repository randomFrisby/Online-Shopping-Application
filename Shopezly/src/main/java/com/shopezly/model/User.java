package com.shopezly.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shopezly.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Email(message = "Invalid Email format")
	@NotNull(message = "Email is mandatory!")
	@Column(unique = true)
	private String email;

	@NotNull(message = "Password is mandatory!")
	@NotBlank(message = "Password cannot be blank!")
	@NotEmpty(message = "Password cannot be empty!")
	@Size(min = 6, max = 15, message = "the password length is not apropriate")

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$", 
//	message = "password must contain at least eight characters, at least one number and both lower and uppercase letters and special characters")
	private String password;

	@NotNull
	@Size(min = 2, max = 20, message = "lastname should be greater then 2 and less the 20")
	private String firstName;
	
	@NotNull
	@Size(min = 2, max = 20, message = "lastname should be greater then 2 and less the 20")
	private String lastName;
	
	
	@NotNull(message = "Role is mandatory!")
	@Enumerated(EnumType.STRING)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Role role;

}