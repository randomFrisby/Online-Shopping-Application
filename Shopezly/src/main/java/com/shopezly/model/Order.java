package com.shopezly.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;

	@NotNull
	private LocalDate orderDate;
	@NotBlank
	@NotNull(message = "OS Status Mandatory")
	@NotEmpty
	private String orderStatus;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.DETACH)
	private Customer customer;
	@NotNull
	@Embedded
	@Valid
	private Address address;

//	private Map<Product, Integer> orderedProducts = new HashMap<>();

}
