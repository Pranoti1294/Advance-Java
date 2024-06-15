package com.studentMVC.service;

import java.util.List;

import com.studentMVC.model.Student;

public interface StudentService {
	int save(Student student);
	List<Student> getAll();
	Student getById(int id);
	int remove(int id);
	int update(int id, Student student); 
}
