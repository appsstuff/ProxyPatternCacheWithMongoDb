package com.appsstuff.pattern.proxy.domian;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="BOOKS")
public class BookDocument {

	@Id
	private long id;
	private String isbn;
	private Book book;
	
	public BookDocument(long id, String isbn , Book book) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.book = book;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	}
