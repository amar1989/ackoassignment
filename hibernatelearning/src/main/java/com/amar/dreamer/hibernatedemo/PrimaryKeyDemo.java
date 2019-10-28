package com.amar.dreamer.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.amar.dreamer.hibernatelearning.Student;

public class PrimaryKeyDemo
{
	public static void main(String str[])
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		// Creating 3 students object
		Student student = new Student("amar", "Singh", "amar.singh@zycus.com");
		Student student1 = new Student("sonal", "Singh", "sonal.singh@zycus.com");
		Student student2 = new Student("Shrawan", "Singh", "shrawan.singh@zycus.com");

		session.beginTransaction();
		// Saving the student object
		session.save(student);
		session.save(student1);
		session.save(student2);
		// Commiting the student object
		session.getTransaction().commit();
		System.out.println("Done");
	}
}
