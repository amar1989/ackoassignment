package com.amar.dreamer.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.amar.dreamer.hibernatelearning.Student;

public class StudentDemo
{
	public static void main(String str[])
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		// Creating a student object
		Student student = new Student("amar", "Singh", "amar.singh@zycus.com");

		session.beginTransaction();
		// Saving the student object
		session.save(student);
		// Commiting the student object
		session.getTransaction().commit();
		System.out.println("Done");
	}
}
