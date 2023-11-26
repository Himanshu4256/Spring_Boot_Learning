package com.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.graphql.Entities.Book;
import com.graphql.service.BookService;

import lombok.Data;

@Controller
public class BookController {
	
	@Autowired 
	private BookService bookService;
	

	@MutationMapping("createBook")
	public Book create(@Argument BookInput book) {
		Book b = new Book();
		b.setTitle(book.getTitle());
		b.setDesc(book.getDesc());
		b.setPrice(book.getPrice());
		b.setAuthor(book.getAuthor());
		b.setPages(book.getPages());
		return this.bookService.create(b);
	}
	
	@QueryMapping("allBooks")
	public List<Book> getAll(){
		return this.bookService.getAll();
		
	}
	
	@QueryMapping("getBook")
	public Book get(@Argument int bookId) // @Argument bcoz yaha query mai data nahi aa rha hai esliye @PathVariable use kiya hai.
	{
		return this.bookService.get(bookId);
	}
}

@Data
class BookInput{
	private String title;
	private String desc;
	private String author;
	private float price;
	private int pages;
}
