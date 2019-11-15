package com.appsstuff.pattern.proxy.apis;

public class BookNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String string , String isbn) {
		super(string + " " + isbn);
	}

}
