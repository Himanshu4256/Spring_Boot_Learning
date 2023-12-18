package com.example.mapStruct.entity;

import java.util.List;

import com.example.mapStruct.dto.Item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String desc;
	private int quantity;
	private long price;
	private String itemId;
	
	//private List<Item> items;
}
