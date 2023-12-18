package com.example.mapStruct.mapper;

import java.util.List;
import java.util.UUID;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.mapStruct.dto.ProductDto;
import com.example.mapStruct.entity.Product;

//componentModel = "spring" -> means "ProductMapperImpl" jo manually create hui hai. use @Component krna for @Autowire. 
@Mapper(componentModel = "spring",imports = UUID.class)
public interface ProductMapper {
	
	//get generate mapperImp class
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
	@Mapping(source = "product.desc",target = "description") //used when variable name is different in DTO and description class
	@Mapping(target = "itemId", expression = "java(UUID.randomUUID().toString())")
	//@Mapping(source = "product.items", target = "itemsList")
	ProductDto modelToDto(Product product);
	
	
	List<ProductDto> modelsToDtos(List<Product> product);
	
	
//	@Mapping(source = "productDto.description", target = "desc")
	@InheritInverseConfiguration  //- ye upr wale ki mapping ko reverse krke auto hi likh dega.
	Product dtoToModel(ProductDto productDto);
	
}
