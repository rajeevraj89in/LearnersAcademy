package com.learners.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.learners.hibernate.entity.Teacher;

public class TeacherDAO {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Teacher.class)
			.buildSessionFactory();

	public List<String> getTeacherList() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<String> teacher = session.createQuery("from teacher").getResultList();
//		session.getTransaction().commit();
		return teacher;
	}
}
