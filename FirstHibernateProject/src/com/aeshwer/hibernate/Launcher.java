package com.aeshwer.hibernate;
/*
 * https://www.gontu.org/downloads-tutorials/
 */
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Launcher {

	public static void main(String[] args) {
		
		Student_Info obj1 = new Student_Info();
		obj1.setName("Aeshwer");
		//obj1.setRollNo(7);
		obj1.setBirthdate(new Date());
		
		/*Student_Info obj2 = new Student_Info();
		obj2.setName("Kanika");
		//obj2.setRollNo(2);
		obj2.setBirthdate(new Date());*/
		
		
		Student_Detail student_Detail1 = new Student_Detail();
		student_Detail1.setNumber("999");
		student_Detail1.setStudent_Info(obj1);			//important step 
		
	/*	Student_Detail student_Detail2 = new Student_Detail();
		student_Detail2.setNumber("111");
		student_Detail2.setStudent_Info(obj2);			//important step 
*/
		/*
		  //creating configuration object  
	    Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	    //creating seession factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  */
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//session.save(obj1);
		//session.save(obj2);
		
		
		session.save(student_Detail1);  // we are not saving student info but still it will be saved...magic of one to one mapping ...this is possible by the important step 
		//session.save(student_Detail2);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}