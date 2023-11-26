package com.graphql.service;

import java.util.List;
import com.graphql.Entities.Book;

public interface BookService {
	
	Book create(Book book);
	List<Book> getAll();
	Book get(int bookId);
}
