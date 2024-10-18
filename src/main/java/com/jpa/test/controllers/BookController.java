package com.jpa.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.entities.Book;
import com.jpa.test.services.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
//	@RequestMapping(value="/books", method = RequestMethod.GET)
//	@GetMapping("/books")
	
//	public Book getBooks() {
//		
//		Book book = new Book();
//		book.setId(12324);
//		book.setTitle("java");
//		book.setAuthor("Rohit");
//		
//		
//		return book;
		
		
//	}
	
//get all books
	@GetMapping("/books")
	
	public List<Book> getBooks() {
	
		return this.bookService.getAllBooks();
	
	}
	
	//Get single books

	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id)
	{
		return bookService.getBookById(id);
		
	}
	@PostMapping("/books")
	public Book addBook(@RequestBody Book  b) {
		Book  s = this.bookService.addBook(b);
		return b;
	}
	
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) 
	{
		this.bookService.deleteBook(bookId);
	}
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookId")
	int bookId)
	{
		this.bookService.updateBook(book,bookId);
		return book;
		
	}
	
	
}
