package com.shopezly.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@EqualsAndHashCode
@ToString(exclude = {"admin"})
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;

	@NotNull(message = "Please Enter Product Name")
	private String productName;

	@NotNull
	@Min(value = 1, message = "Price Not be Null Nither 0 (Zero).")
	private Integer price;

	@NotNull(message = "Please set the Product Color")
	private String color;

	@NotNull(message = "Dimension Should not be Null")
	private String dimension;

	@NotNull(message = "Please Enter Product Specification.")
	private String specification;

	@NotNull(message = "Please Enter Manufacturer Details")
	private String manufacturer;

	@NotNull
	@Min(value = 0, message = "Quantity Not be Null Nither 0 (Zero).")
	private Integer quantity;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "adminId")
	Admin admin;
	
}
