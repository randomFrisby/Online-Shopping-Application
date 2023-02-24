package com.shopezly.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
@Entity
@PrimaryKeyJoinColumn(name = "adminId")
public class Admin extends User {
	
	@NotNull
	@Size(min = 2, max = 20, message = "Lastname should be Greater than 2 and Less than 20")
	private String firstName;
	
	@NotNull
	@Size(min = 2, max = 20, message = "Lastname should be Greater than 2 and Less than 20")
	private String lastName;

	@NotNull
	@Min(value = 18, message = "You are not Adult.")
	private Integer age;
	
}
