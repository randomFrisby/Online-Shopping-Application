package com.shopezly.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopezly.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	private LocalDate orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
//	@ElementCollection
//	@CollectionTable(name = "ordered_product", joinColumns = @JoinColumn(name = "order_id"))
//	@Column(name = "product_id")
//	private Map<Product, Integer> orderedProducts = new HashMap<>();
	
	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "addressId")
    private Address address;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
}
