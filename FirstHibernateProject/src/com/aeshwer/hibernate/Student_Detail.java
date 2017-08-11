package com.aeshwer.hibernate;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name ="STUDENT_DETAIL")
public class Student_Detail {

	//@GeneratedValue(strategy = GenerationType.AUTO)   dont want hibernate to generate a new id ...but use the one generated for student_info class
	@Id
	@GeneratedValue(generator = "newGenerator") 
	@GenericGenerator(name = "newGenerator", strategy = "foreign",parameters = { @Parameter(value = "Student_Info", name = "property") })
	private int rollNo;
	
	@Column(name ="MobileNumber" , nullable= false)
	private String number;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="rollNo")
	private Student_Info student_Info;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Student_Info getStudent_Info() {
		return student_Info;
	}

	public void setStudent_Info(Student_Info student_Info) {
		this.student_Info = student_Info;
	}


}