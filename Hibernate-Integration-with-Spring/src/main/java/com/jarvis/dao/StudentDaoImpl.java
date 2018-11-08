package com.jarvis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.jarvis.model.Student;

public class StudentDaoImpl implements StudentDao {

	@Autowired
	SessionFactory sessionFactory;

	public Boolean saveStudent(Student student) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(student);
		transaction.commit();

		return transaction.wasCommitted();
	}

	public List<Student> getList() {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Student> students = session.createCriteria(Student.class).list();
		return students;
	}

	public Student getStudentById(Integer id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// Student student = (Student) session.load(Student.class, id);
		Student student = (Student) session.get(Student.class, id);
		System.out.println(student.getId());
		return student;
	}

	public Boolean deleteStudent(Integer id) {
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Student student=(Student) session.get(Student.class, id);
		System.out.println(student.getId());
		session.delete(student);
		tx.commit();
		return tx.wasCommitted();
	}

}
