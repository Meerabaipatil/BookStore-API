package com.example.BookStore.Service;

import java.util.List;

import com.example.BookStore.Entity.Author;

public interface AuthorService {

	

	Author getAuthorById(Integer id);

	Author createAuthor(Author author);

	Author updateAuthor(Integer id, Author author);

	void deleteAuthor(Integer id);

	List<Author> getAllAuthors();

	

}
