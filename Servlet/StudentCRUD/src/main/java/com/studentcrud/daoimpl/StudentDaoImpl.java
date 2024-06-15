package com.studentcrud.daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.studentcrud.dao.StudentDao;
import com.studentcrud.utility.SqlUtil;
import com.studentdrud.module.Student;

public class StudentDaoImpl implements StudentDao{

	@Override
	public int save(Student student) {
		
		int result =-1;
		try {
			SqlUtil.connectDB();
			String qryString = " INSERT INTO stud values('"+student.getId()+"','"+student.getName()+"','"+student.getPhone()+"','"+student.getMarks()+"','"+student.getCity()+"','"+student.getGender()+"')";
			result = SqlUtil.insert(qryString);
			SqlUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public List<Student> getAll() {
		List<Student> studentList = new ArrayList();
		Student student;
		try {
			SqlUtil.connectDB();
			String qryString = "SELECT * FROM stud";
			ResultSet resultset = SqlUtil.fetch(qryString);
			while (resultset.next()) {
				int id = resultset.getInt("id");
				String name = resultset.getString("name");
				String phone = resultset.getString("phone");
				float marks = resultset.getFloat("marks");
				String city = resultset.getString("city");
				String gender = resultset.getString("gender");
				student = new Student(id, name, phone, gender, city, marks);
				
				studentList.add(student);
			}
			SqlUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return studentList;
	}

	@Override
	public Student getById(int id) {
		Student student = null;
		
		try {
			SqlUtil.connectDB();
			String qryString = "SELECT * from stud WHERE id="+id;
			ResultSet resultset = SqlUtil.fetch(qryString);
			if(resultset.next()) {
				student.setId(resultset.getInt(0));
				student.setName(resultset.getString(1));
				student.setPhone(resultset.getString(2));
				student.setMarks(resultset.getFloat(3));
				student.setCity(resultset.getString(4));
				student.setGender(resultset.getString(5));			
			}
			SqlUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return student;
	}

	@Override
	public int remove(int id) {
		int result = -1;
		try {
			SqlUtil.connectDB();
			String qryString = "DELETE FROM stud WHERE id="+id;
			result = SqlUtil.delete(qryString);
			SqlUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

}
