package com.shopezly.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;

	@NotNull(message = "Please Enter Valid Street No.")

	private Integer streetNo;

	private String buildingName;
	@NotNull(message = "Please Enter Valid City.")
	private String city;

	@NotNull(message = "Please Enter Valid State.")
	private String state;

	@NotNull(message = "Please Enter Valid Country.")
	private String country;

	@NotNull(message = "Enter Pincode with format ::\"[1-9]{1}[0-9]{5}\"::")
	@Pattern(regexp = "[1-9]{1}[0-9]{5}", message = "Pincode Should be 6 Digit Only")
	private String pincode;

	@JsonIgnore
	@JoinColumn(name = "customerId")
	@ManyToOne()
	private Customer customer;
}
