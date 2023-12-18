package com.example.mapStruct.dto;


import lombok.Data;

@Data
public class ProductDto {
	
	private int id;
	private String name;
	private String description;
	private int quantity;
	private long price;
	private String itemId;
	//private List<Item> itemsList;
	
}
