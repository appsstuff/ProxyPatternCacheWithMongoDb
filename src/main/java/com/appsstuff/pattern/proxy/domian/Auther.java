package com.appsstuff.pattern.proxy.domian;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity()
@Table(name="AUTHER")
@SequenceGenerator(initialValue = 1,sequenceName = "authersSeq",allocationSize = 1, name = "authersSeq")
public class Auther {
	
	@Id
	private String id;
	private String name;
	
	@OneToOne(optional = false ,fetch = FetchType.LAZY)
	private Book isbn;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setIsbn(Book isbn) {
		this.isbn = isbn;
	}
	public Auther(String id, String name, Book isbn) {
		super();
		this.id = id;
		this.name = name;
		this.isbn = isbn;
	}
	public Auther() {
		super();
	}
	
	
}
