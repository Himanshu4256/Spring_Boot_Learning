package com.example.mapStruct.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mapStruct.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
