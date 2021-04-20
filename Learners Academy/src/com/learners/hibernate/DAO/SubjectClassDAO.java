package com.learners.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.learners.hibernate.entity.SubjectClass;

public class SubjectClassDAO {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(SubjectClass.class)
			.buildSessionFactory();

	public void insertData(SubjectClass subjectClass) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query check = session.createQuery("FROM subject_class WHERE className = :class AND subject = :subject");
		check.setParameter("class", subjectClass.getClassName());
		check.setParameter("subject", subjectClass.getSubject());
		List<String> data = check.getResultList();
		// System.out.println(data.toString());
		if (data.isEmpty()) {
			session.save(subjectClass);
			System.out.println("Data Inserted Successfully");
		} else {
			System.out.println("Data Already Exist");
		}
		session.getTransaction().commit();
	}

	public void insertData2(SubjectClass subjectClass) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query check = session.createQuery("FROM subject_class WHERE className = :class AND subject = :subject");
		check.setParameter("class", subjectClass.getClassName());
		check.setParameter("subject", subjectClass.getSubject());
		List<SubjectClass> data = check.getResultList();
		// System.out.println(data.toString());
		if (data.isEmpty()) {
			session.save(subjectClass);
			System.out.println("Data Inserted Successfully");
		} else {
			int id = 0;
			for(SubjectClass subcls : data){
				id = subcls.getId();
			}
			String hql = "UPDATE subject_class set className = :class, subject = :subject, teacher = :teacher " + "WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("class", subjectClass.getClassName());
			query.setParameter("subject", subjectClass.getSubject());
			query.setParameter("teacher", subjectClass.getTeacher());
			query.setParameter("id", id);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
			System.out.println("Data has been updated");
		}
		session.getTransaction().commit();
	}
	
	public List<String> getClassWiseSubject(String myclass){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query check;
		if(myclass == null){
			check = session.createQuery("FROM subject_class");
		}else{
			check = session.createQuery("FROM subject_class WHERE className = :class");
			check.setParameter("class", myclass);
		}
		List<String> subjects = check.getResultList();
		return subjects;
	}
	
	public List<String> getClassTeacher(String myclass){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query check;
		if(myclass == null){
			check = session.createQuery("FROM subject_class");
		}else{
			check = session.createQuery("FROM subject_class WHERE className = :class");
			check.setParameter("class", myclass);
		}
		List<String> teachers = check.getResultList();
		return teachers;
	}

}
