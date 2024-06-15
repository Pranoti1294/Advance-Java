package com.studentcrud.dao;

import java.util.List;

import com.studentdrud.module.Student;

public interface StudentDao {
	int save(Student student);
	List<Student> getAll();
	Student getById(int id);
	int remove(int id);
	
	
}
