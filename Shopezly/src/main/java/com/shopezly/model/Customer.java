package com.shopezly.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@PrimaryKeyJoinColumn(name = "customerId")
public class Customer extends User {

	@NotNull(message = "mobile is mandatory")
	@Pattern(regexp = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$", message = "enter a valid indian number")
	private String mobile;

	
}