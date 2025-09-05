package com.example.BookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookStore.Entity.Author;

public interface AuthorRepository  extends JpaRepository<Author, Integer>{

}
