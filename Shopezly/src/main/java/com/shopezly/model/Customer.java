package com.shopezly.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
@PrimaryKeyJoinColumn(name = "customerId")
public class Customer extends User {

	@NotNull
	@Size(min = 2, max = 20, message = "Lastname should be Greater then 2 and Less than 20")
	private String firstName;
	
	@NotNull
	@Size(min = 2, max = 20, message = "lastname should be greater then 2 and Less than 20")
	private String lastName;
	
	@NotNull(message = "Mobile is mandatory")
	@Pattern(regexp = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$", message = "Please Enter a valid Indian Number")
	private String mobile;

	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "customer")
	private Set<Address> addresses = new HashSet<>();
	
}