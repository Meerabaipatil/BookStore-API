package com.example.BookStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookStore.Entity.Book;
import com.example.BookStore.RS.ResponseStructure;
import com.example.BookStore.Service.BookService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/book")

public class BookController {
	
	  @Autowired
	    private BookService service;
	  
	  @GetMapping("/getAll")
	    public ResponseEntity<ResponseStructure<List<Book>>> all() {
	        List<Book> response = service.getAllBooks();

	        ResponseStructure<List<Book>> apiResponse = new ResponseStructure<>();
	        apiResponse.setData(response);
	        apiResponse.setMessage("Books fetched successfully");
	        apiResponse.setStatuscode(HttpStatus.OK.value());

	        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	    }

	  @GetMapping("/{id}")
	    public ResponseEntity<ResponseStructure<Book>> one(@PathVariable Integer id) {
	        Book book = service.getBookById(id);

	        ResponseStructure<Book> apiResponse = new ResponseStructure<>();
	        apiResponse.setData(book);
	        apiResponse.setMessage("Book fetched successfully");
	        apiResponse.setStatuscode(HttpStatus.OK.value());

	        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	    }
	  
	  @PostMapping("/save")
	    public ResponseEntity<ResponseStructure<Book>> create(@RequestBody Book book, @RequestParam Integer authorId) {
	        Book saved = service.createBook(book, authorId);

	        ResponseStructure<Book> apiResponse = new ResponseStructure<>();
	        apiResponse.setData(saved);
	        apiResponse.setMessage("Book created successfully");
	        apiResponse.setStatuscode(HttpStatus.CREATED.value());

	        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
	    }
	  
	  @PutMapping("/{id}")
	    public ResponseEntity<ResponseStructure<Book>> update(@PathVariable Integer id, @RequestBody Book book, @RequestParam Integer authorId) {
	        Book updated = service.updateBook(id, book, authorId);

	        ResponseStructure<Book> apiResponse = new ResponseStructure<>();
	        apiResponse.setData(updated);
	        apiResponse.setMessage("Book updated successfully");
	        apiResponse.setStatuscode(HttpStatus.OK.value());

	        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	    }
	  
	  @DeleteMapping("/{id}")
	    public ResponseEntity<ResponseStructure<String>> delete(@PathVariable Integer id) {
	        service.deleteBook(id);

	        ResponseStructure<String> apiResponse = new ResponseStructure<>();
	        apiResponse.setData("Book deleted successfully");
	        apiResponse.setMessage("Delete operation successful");
	        apiResponse.setStatuscode(HttpStatus.OK.value());

	        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	    }


}
