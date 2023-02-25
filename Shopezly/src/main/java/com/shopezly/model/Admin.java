package com.shopezly.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
	
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "admin")
	Set<Product> products = new HashSet<>();
}
