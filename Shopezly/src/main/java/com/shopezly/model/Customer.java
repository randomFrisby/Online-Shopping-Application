package com.shopezly.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
	@Size(min = 2, max = 20, message = "lastname should be greater then 2 and less the 20")
	private String firstName;
	
	@NotNull
	@Size(min = 2, max = 20, message = "lastname should be greater then 2 and less the 20")
	private String lastName;
	
	@NotNull(message = "mobile is mandatory")
	@Pattern(regexp = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$", message = "enter a valid indian number")
	private String mobile;

	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "customer")
	private Set<Address> addresses = new HashSet<>();
	
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "customer")
	private List<Orders> orders = new ArrayList<>();
	
	
	
}


