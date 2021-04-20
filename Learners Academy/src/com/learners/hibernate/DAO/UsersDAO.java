package com.learners.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.learners.hibernate.entity.SubjectClass;
import com.learners.hibernate.entity.Users;


public class UsersDAO {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
			.buildSessionFactory();
	
	public List<Users> getUser(String email, String password){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query check = session.createQuery("FROM users WHERE email = :email AND password = :password");
		check.setParameter("email", email);
		check.setParameter("password", password);
		List<Users> data = check.getResultList();
		return data;
	}
}
