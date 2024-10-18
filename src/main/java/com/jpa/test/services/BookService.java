package com.jpa.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.test.dao.BookRepository;
import com.jpa.test.entities.Book;

@Component
public class BookService {
@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks(){
	List<Book> list =(List<Book>)this.bookRepository.findAll();
		return list;
	}
// private static List<Book> list = new ArrayList<>();

// static {
// 	list.add(new Book(12,"java","jjk"));
// 	list.add(new Book(15,"dfd","wer"));
// 	list.add(new Book(126,"dfd","sdf"));
// }


public Book addBook(Book b) {
	// TODO Auto-generated method stub
	Book result = bookRepository.save(b);
	return result;
}





public void deleteBook(int bookId)
{
bookRepository.deleteById(bookId);
}



public Book getBookById(int id) {
	Book book = null;
	

	// book = list.stream().filter(e->e.getId() == id).findFirst().get();
try {
	book = this.bookRepository.findById(id);

} catch (Exception e) {
	// TODO: handle exception
}

return book;
}





public void updateBook(Book b, int bookId) {
	// TODO Auto-generated method stub
	
	b.setId(bookId);
	bookRepository.save(b);

}

}
