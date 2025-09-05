package com.example.BookStore.Service;

import java.util.List;

import com.example.BookStore.Entity.Book;

public interface BookService {

	List<Book> getAllBooks();

	Book getBookById(Integer id);

	Book createBook(Book book, Integer authorId);

	Book updateBook(Integer id, Book book, Integer authorId);

	void deleteBook(Integer id);

	

}
