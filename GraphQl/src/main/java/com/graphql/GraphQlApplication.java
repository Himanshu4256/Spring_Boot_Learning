package com.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.graphql.Entities.Book;
import com.graphql.service.BookService;

@SpringBootApplication
public class GraphQlApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService; 
	
	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book b1 = new Book();
		b1.setTitle("GraphQl Prototype");
		b1.setDesc("For GraphQl Learning");
		b1.setPages(2800);
		b1.setPrice(1500);
		b1.setAuthor("Martin Luther");
		
		Book b2 = new Book();
		b2.setTitle("DSA Toutorial");
		b2.setDesc("DSA with Java");
		b2.setPages(3200);
		b2.setPrice(1500);
		b2.setAuthor("James Gosling");
		
		Book b3 = new Book();
		b3.setTitle("Logic Building");
		b3.setDesc("Build your logics");
		b3.setPages(3000);
		b3.setPrice(1600);
		b3.setAuthor("Himanshu Sharma");
		
		this.bookService.create(b1);
		this.bookService.create(b2);
		this.bookService.create(b3);
		
		
	}
	


}
