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
import org.springframework.web.bind.annotation.RestController;

import com.example.BookStore.RS.ResponseStructure;
import com.example.BookStore.Service.AuthorService;
import com.example.BookStore.Entity.Author;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
	
	@Autowired
	private AuthorService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<ResponseStructure<List<Author>>> getAllAuthors() {
	    List<Author> response = service.getAllAuthors();

	    ResponseStructure<List<Author>> apiResponse = new ResponseStructure<>();
	    apiResponse.setData(response);
	    apiResponse.setMessage("API ran Successfully");
	    apiResponse.setStatuscode(HttpStatus.OK.value());

	    return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	} 
	
	
	@GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Author>> getAuthorById(@PathVariable Integer id) {
        Author author = service.getAuthorById(id);

        ResponseStructure<Author> apiResponse = new ResponseStructure<>();
        apiResponse.setData(author);
        apiResponse.setMessage("Author fetched successfully");
        apiResponse.setStatuscode(HttpStatus.OK.value());

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
	
	 @PostMapping("/save")
	    public ResponseEntity<ResponseStructure<Author>> createAuthor(@RequestBody Author author) {
	        Author saved = service.createAuthor(author);

	        ResponseStructure<Author> apiResponse = new ResponseStructure<>();
	        apiResponse.setData(saved);
	        apiResponse.setMessage("Author created successfully");
	        apiResponse.setStatuscode(HttpStatus.CREATED.value());

	        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<ResponseStructure<Author>> updateAuthor(@PathVariable Integer id, @RequestBody Author author) {
	        Author updated = service.updateAuthor(id, author);

	        ResponseStructure<Author> apiResponse = new ResponseStructure<>();
	        apiResponse.setData(updated);
	        apiResponse.setMessage("Author updated successfully");
	        apiResponse.setStatuscode(HttpStatus.OK.value());

	        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<ResponseStructure<String>> deleteAuthor(@PathVariable Integer id) {
	        service.deleteAuthor(id);

	        ResponseStructure<String> apiResponse = new ResponseStructure<>();
	        apiResponse.setData("Author deleted successfully");
	        apiResponse.setMessage("Delete operation successful");
	        apiResponse.setStatuscode(HttpStatus.OK.value());

	        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	    }

}
