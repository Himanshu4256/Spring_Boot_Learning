package com.graphql.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphql.Entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
