package com.studentMVC.serviceImpl;

import java.util.List;

import com.studentMVC.daoimpl.StudentDAOImpl;
import com.studentMVC.model.Student;
import com.studentMVC.service.StudentService;

public class StudentServiceImpl implements StudentService {

	StudentDAOImpl studentDAOImpl ;
	
	public StudentServiceImpl() {
		studentDAOImpl = new StudentDAOImpl();
	}
	
	@Override
	public int save(Student student) {		
		return studentDAOImpl.save(student);		
	}

	@Override
	public List<Student> getAll() {
		return studentDAOImpl.getAll();
	}

	@Override
	public Student getById(int id) {
		return studentDAOImpl.getById(id);
	}

	@Override
	public int remove(int id) {
		return studentDAOImpl.remove(id);
	}

	@Override
	public int update(int id, Student student) {
		return studentDAOImpl.update(id, student); 
	}

}
