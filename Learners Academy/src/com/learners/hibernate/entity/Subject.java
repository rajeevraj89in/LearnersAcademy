package com.learners.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "subject")
@Table(name = "subject")
public class Subject {
	@Id
	@Column(name = "id")
	int id;
	@Column(name = "name")
	String name;

	public Subject(){
		
	}

	public Subject(String name) {
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
