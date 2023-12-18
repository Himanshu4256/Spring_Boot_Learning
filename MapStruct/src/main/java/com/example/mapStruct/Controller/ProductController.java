package com.example.mapStruct.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapStruct.DAO.ProductRepository;
import com.example.mapStruct.dto.ProductDto;
import com.example.mapStruct.entity.Product;
import com.example.mapStruct.mapper.ProductMapper;

@RestController
public class ProductController {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/products")
	public ResponseEntity<Product> save(@RequestBody ProductDto productDto){
		Product product = productRepository.save(productMapper.dtoToModel(productDto));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> findAll(){
		return new ResponseEntity<>(productMapper.modelsToDtos(productRepository.findAll()),HttpStatus.OK);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductDto> findById(@PathVariable(value = "id") Integer id){
		return new ResponseEntity<>(productMapper.modelToDto(productRepository.findById(id).get()), HttpStatus.OK);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<ProductDto> deleteById(@PathVariable(value = "id") Integer id){
		
		ProductDto productDto = productMapper.modelToDto(productRepository.findById(id).get());
		productRepository.deleteById(productDto.getId());
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
