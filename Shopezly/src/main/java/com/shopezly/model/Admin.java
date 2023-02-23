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
	@Size(min = 2, max = 20, message = "lastname should be greater then 2 and less the 20")
	private String firstName;
	
	@NotNull
	@Size(min = 2, max = 20, message = "lastname should be greater then 2 and less the 20")
	private String lastName;

	@NotNull
	@Min(value = 18, message = "age cannot be less than 18")
	private Integer age;
	
}
