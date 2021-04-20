package com.learners.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="class")
@Table(name="class")
public class Myclass {
	@Id
	@Column(name="id")
	int id;
	@Column(name="name")
	String name;
	
	public Myclass(){
		
	}

	public Myclass(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Myclass [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	
}
