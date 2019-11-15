package com.appsstuff.pattern.proxy.domian;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.appsstuff.pattern.proxy.service.BookTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity()
@Table(name="BOOKS")
@SequenceGenerator(initialValue = 1,sequenceName = "booksSeq",allocationSize = 1, name = "booksSeq")
public class Book{

	@Id
	@JsonIgnore
	private long id;
	private String isbn;
	private String name;
	
	@Transient
	private String  storedIn;
	
	public String getStoredIn() {
		return storedIn;
	}
	public void setStoredIn(String storedIn) {
		this.storedIn = storedIn;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="auther")
	private Auther auther;
	
	private BookTypeEnum type;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Auther getAuther() {
		return auther;
	}
	public void setAuther(Auther auther) {
		this.auther = auther;
	}
	public BookTypeEnum getType() {
		return type;
	}
	public void setType(BookTypeEnum type) {
		this.type = type;
	}
	public Book(long id, String isbn, String name, Auther auther, BookTypeEnum type) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.name = name;
		this.auther = auther;
		this.type = type;
	}
	public Book() {
		super();
	}
}
