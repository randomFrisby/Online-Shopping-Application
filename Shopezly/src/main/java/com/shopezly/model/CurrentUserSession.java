package com.shopezly.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CurrentUserSession {
	
	@Id
	@Column(unique = true)
	private Integer userId;

	private String uuid;
	
	private LocalDateTime localDateTime;
	
	private String response;

}