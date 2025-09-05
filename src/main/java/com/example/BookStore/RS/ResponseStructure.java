package com.example.BookStore.RS;

import com.example.BookStore.Entity.Author;

import lombok.Data;


public class ResponseStructure<T> {
	
	private int statuscode;
	private String message;
	private T data;
	
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
	

}
