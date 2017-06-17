package com.gontuseries.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		Student student = new Student();
		student.setStudent_name("Gontu1");

		StudentDetail studentDetail = new StudentDetail();
		studentDetail.setStudent_mobile_number("99XX1XXX77");
		studentDetail.setStudent(student);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//please note I am not saving student object but still it will be saved in database
		//that's the magic of one to one mapping 
		session.save(studentDetail);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

	
}
