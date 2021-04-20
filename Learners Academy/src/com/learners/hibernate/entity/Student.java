package com.learners.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "student")
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "id")
	int id;
	@Column(name = "name")
	String name;
	@Column(name = "class")
	String className;
	@Column(name = "roll_no")
	String rollNo;
	@Column(name = "dob")
	String dob;
	@Column(name = "contact_no")
	String contactNo;
	@Column(name = "address")
	String address;
	
	public Student(){}

	public Student(String name, String className, String rollNo, String dob, String contactNo, String address) {
		super();
		this.name = name;
		this.className = className;
		this.rollNo = rollNo;
		this.dob = dob;
		this.contactNo = contactNo;
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", className=" + className + ", rollNo=" + rollNo + ", dob="
				+ dob + ", contactNo=" + contactNo + ", address=" + address + "]";
	}
	
	

}
