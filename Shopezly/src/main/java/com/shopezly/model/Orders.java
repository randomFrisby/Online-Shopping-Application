package com.shopezly.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.shopezly.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyJoinColumn;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
	
	@NotNull(message = "Order Date is mandatory")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate orderDate;
	
	
	@NotNull(message = "Order Status Mandatory")
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Transient
	List<Integer> productIds = new ArrayList<>();
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Transient
	List<Integer> productQty = new ArrayList<>();
	
	
	@JsonProperty(access = Access.READ_ONLY)
	@ElementCollection
	@CollectionTable(name = "orders_products", joinColumns = @JoinColumn(name = "orderId"))
    @MapKeyJoinColumn(name = "productId")
    @Column(name = "products_quantity")
	private Map<Product, Integer> orderedProducts = new HashMap<>();
	
	
	@NotNull(message = "Please provide address while creating order")
	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "addressId")
    private Address address;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
}
