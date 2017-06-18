package com.gontuseries.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		StudentCertification studentCertification1 = new StudentCertification();
		studentCertification1.setCertification_name("Core JAVA Certification Exam");

		StudentCertification studentCertification2 = new StudentCertification();
		studentCertification2.setCertification_name("Oracle DB Certification Exam");

		Student student1 = new Student();
		student1.setStudent_name("Gontu1");
		(student1.getStudentCertification()).add(studentCertification1);

		Student student2 = new Student();
		student2.setStudent_name("Gontu1");
		(student2.getStudentCertification()).add(studentCertification2);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// please note I am not saving studentCertification object but still it will
		// be saved in a database that's the magic of Many to Many mapping
		session.save(student1);
		session.save(student2);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}

}
