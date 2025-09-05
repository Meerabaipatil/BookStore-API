package com.example.BookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookStore.Entity.Book;

public interface BookRepository  extends JpaRepository<Book, Integer>{

}
