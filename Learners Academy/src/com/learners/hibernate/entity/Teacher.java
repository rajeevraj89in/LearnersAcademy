package com.learners.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "teacher")
@Table(name = "teacher")
public class Teacher {
	@Id
	@Column(name = "id")
	int id;
	@Column(name = "name")
	String name;
	@Column(name = "email")
	String email;
	@Column(name = "contact_no")
	String contactNo;
	@Column(name = "qualification")
	String qualification;
	@Column(name = "address")
	String address;
	
	public Teacher(){}

	public Teacher(String name, String email, String contactNo, String qualification, String address) {
		super();
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.qualification = qualification;
		this.address = address;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", qualification=" + qualification + ", address=" + address + "]";
	}

}
