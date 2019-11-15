package com.appsstuff.pattern.proxy.domian;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity()
@Table(name="AUTHER")
@SequenceGenerator(initialValue = 1,sequenceName = "authersSeq",allocationSize = 1, name = "authersSeq")
public class Auther {
	
	@Id
	private String id;
	private String name;

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

	
	public Auther(String id, String name, Book isbn) {
		super();
		this.id = id;
		this.name = name;
	}
	public Auther() {
		super();
	}
	
	
}
