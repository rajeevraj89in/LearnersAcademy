package com.learners.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.learners.hibernate.entity.Student;

public class StudentDAO {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
			.buildSessionFactory();

	public List<String> getStudentList() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<String> student = session.createQuery("from student").getResultList();
//		session.getTransaction().commit();
		return student;
	}
	
	public List<String> getClassWiseStudent(String myclass){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query check = session.createQuery("FROM student WHERE className = :class");
		check.setParameter("class", myclass);
		List<String> students = check.getResultList();
		return students;
	}
}
