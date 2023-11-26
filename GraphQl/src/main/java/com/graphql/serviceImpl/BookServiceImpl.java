package com.graphql.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.graphql.Entities.Book;
import com.graphql.dao.BookRepository;
import com.graphql.service.BookService;

@Service
public class BookServiceImpl  implements BookService{

	private BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Override
	public Book create(Book book) {
		// TODO Auto-generated method stub
		return this.bookRepository.save(book);
	}

	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return this.bookRepository.findAll();
	}

	@Override
	public Book get(int bookId) {
		// TODO Auto-generated method stub
		return this.bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book Not found"));
	}

}
