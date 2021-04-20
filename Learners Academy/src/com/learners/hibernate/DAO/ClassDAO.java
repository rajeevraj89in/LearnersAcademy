package com.learners.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learners.hibernate.entity.Myclass;

public class ClassDAO {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Myclass.class)
			.buildSessionFactory();

	public List<String> getClassList() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<String> classlist = session.createQuery("from class").getResultList();
//		session.getTransaction().commit();
		return classlist;
	}

}
