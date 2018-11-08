package com.jarvis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jarvis.dao.StudentDao;
import com.jarvis.model.Student;

public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	public Boolean saveStudent(Student student) {

		return studentDao.saveStudent(student);

	}

	public List<Student> getList() {
		// TODO Auto-generated method stub
		return studentDao.getList();
	}

	public Student getStudentById(Integer id) {
		// TODO Auto-generated method stub
		return studentDao.getStudentById(id);
	}

	public Boolean deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		return studentDao.deleteStudent(id);
	}

}
