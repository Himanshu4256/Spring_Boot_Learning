package com.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(
		name = "products",
		uniqueConstraints = {  // ye column k data unique banata hai.
				@UniqueConstraint(
						name = "sku_name",
						columnNames = "sku"
						)
			}
		)
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.AUTO) -> Ye ek extra tabel bnata hai "products_seq" name ki jo primary key ka sequence manage krti hai.
//	GenerationType.SEQUENCE = ye large db k liye use hoti hai for generate seq db for unique values it also create seq table
	private Long id;
	private String sku;
	@Column(nullable = false)  // name can't be null
	private String name;
	private String description; 
	private BigDecimal price;
	private boolean active;
	private String imageUrl;
	@CreationTimestamp
	private LocalDateTime dateCreated;
	@UpdateTimestamp
	private LocalDateTime lastUpdates;
}
