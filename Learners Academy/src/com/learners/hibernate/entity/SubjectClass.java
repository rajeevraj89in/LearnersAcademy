package com.learners.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "subject_class")
@Table(name = "subject_class")
public class SubjectClass {
	@Id
	@Column(name = "id")
	int id;
	@Column(name = "class")
	String className;
	@Column(name = "subject")
	String subject;
	@Column(name = "teacher")
	String teacher;

	public SubjectClass() {

	}

	public SubjectClass(String className, String subject, String teacher) {
		super();
		this.className = className;
		this.subject = subject;
		this.teacher = teacher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "SubjectClass [id=" + id + ", className=" + className + ", subject=" + subject + ", teacher=" + teacher
				+ "]";
	}

}
