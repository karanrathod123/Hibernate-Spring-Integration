package com.jarvis.dao;

import java.util.List;

import com.jarvis.model.Student;

public interface StudentDao {

	public Boolean saveStudent(Student student);

	public List<Student> getList();

	public Student getStudentById(Integer id);

	public Boolean deleteStudent(Integer id);

}
