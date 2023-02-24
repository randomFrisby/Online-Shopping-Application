package com.shopezly.model;

import java.util.Locale.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String productId;

	@NotNull(message = "Please Enter Product Name")
	private String productName;

	@NotNull
	@Min(value = 1, message = "Price Not be Null Nither 0 (Zero).")
	private double price;

	@NotNull(message = "Please set the Product Color")
	private String color;

	@NotNull(message = "Diamention Should not be Null")
	private String dimension;

	@NotNull(message = "Please Enter Product Specification.")
	private String specification;

	@NotNull(message = "Please Enter Manufacturer Details")
	private String manufacturer;

	@NotNull
	@Min(value = 1, message = "Quantity Not be Null Nither 0 (Zero).")
	private int quantity;

//	@ManyToOne
//	private Category category;

}
