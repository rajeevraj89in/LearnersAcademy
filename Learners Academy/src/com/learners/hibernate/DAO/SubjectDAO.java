package com.learners.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.learners.hibernate.entity.Subject;

public class SubjectDAO {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Subject.class)
			.buildSessionFactory();

	public List<String> getSubjectList() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<String> subject = session.createQuery("from subject").getResultList();
//		session.getTransaction().commit();
		return subject;
	}
}
