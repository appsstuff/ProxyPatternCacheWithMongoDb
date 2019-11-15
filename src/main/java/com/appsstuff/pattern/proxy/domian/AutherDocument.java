//package com.appsstuff.pattern.proxy.domian;
//
//import javax.persistence.Id;
//
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document(collection ="AUTHER")
//public class AutherDocument {
//	
//	@Id
//	private String id;
//	private String name;
//	private Book isbn;
//	
//	
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setIsbn(Book isbn) {
//		this.isbn = isbn;
//	}
//	public AutherDocument(String id, String name, Book isbn) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.isbn = isbn;
//	}
//	public AutherDocument() {
//		super();
//	}
//	
//	
//}
