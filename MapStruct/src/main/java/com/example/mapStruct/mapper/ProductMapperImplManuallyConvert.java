//package com.example.mapStruct.mapper;
//
//import com.example.mapStruct.dto.ProductDto;
//import com.example.mapStruct.entity.Product;
//
//public class ProductMapperImpl implements ProductMapper {
//
//	@Override
//	public ProductDto modelToDto(Product product) {
//		ProductDto productDto = new ProductDto();
//		productDto.setId(product.getId());
//		productDto.setName(product.getName());
//		productDto.setPrice(product.getPrice());
//		productDto.setQuantity(product.getQuantity());
//		return productDto;
//	}
//
//	@Override
//	public Product dtoToModel(ProductDto productDto) {
//		Product product = new Product(); 
//		product.setId(productDto.getId());
//		product.setName(productDto.getName());
//		product.setPrice(productDto.getPrice());
//		product.setQuantity(productDto.getQuantity());
//		return product;
//	}
//
//}



