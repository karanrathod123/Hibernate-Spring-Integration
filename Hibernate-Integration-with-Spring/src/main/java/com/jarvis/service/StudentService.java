package com.jarvis.service;

import java.util.List;

import com.jarvis.model.Student;

public interface StudentService 
{

	public Boolean saveStudent(Student student);

	public List<Student> getList();

	public Student getStudentById(Integer id);

	public Boolean deleteStudent(Integer id);
	

}
