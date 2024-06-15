package com.studentMVC.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicTreeUI.TreeToggleAction;

import com.mysql.cj.protocol.Resultset;
import com.studentMVC.dao.StudentDAO;
import com.studentMVC.model.Student;
import com.studentMVC.utility.SqlUtil;

public class StudentDAOImpl implements StudentDAO{
	
	@Override
	public int save(Student student) {
		int result = -1;
		try {
			SqlUtil.connectDB();
			SqlUtil.statement = SqlUtil.connection.prepareStatement("insert into stud values(?,?,?,?,?,?)");
			SqlUtil.statement.setInt(1, student.getId());
			SqlUtil.statement.setString(2, student.getName());
			SqlUtil.statement.setString(3, student.getPhone());
			SqlUtil.statement.setFloat(4, student.getMarks());
			SqlUtil.statement.setString(5, student.getCity());
			SqlUtil.statement.setString(6, student.getGender());
			
			result = SqlUtil.insert();
			SqlUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Student> getAll() {
		List<Student> studentList = new ArrayList<Student>();
		
		try {
			
			SqlUtil.connectDB();
			SqlUtil.statement = SqlUtil.connection.prepareStatement("select * from stud");
			ResultSet resultSet = SqlUtil.fetch();
			if (resultSet!=null) {
				while(resultSet.next()){
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					String phone = resultSet.getString("phone");
					float marks = resultSet.getFloat("marks");
					String city = resultSet.getString("city");
					String gender = resultSet.getString("gender");
					Student student = new Student(id, name, phone, marks, city, gender);
					studentList.add(student);
				}
				
			}
			SqlUtil.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return studentList;
	}

	@Override
	public Student getById(int id) {
		Student student = null;
		
		try {
			SqlUtil.connectDB();
			
			SqlUtil.statement = SqlUtil.connection.prepareStatement("select * from stud where id=?");
			
			ResultSet resultSet = SqlUtil.fetch();
			SqlUtil.statement.setInt(1, id);
			if(resultSet!=null) {
				
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				float marks = resultSet.getFloat("marks");
				String city = resultSet.getString("city");
				String gender = resultSet.getString("gender");
				student = new Student(id, name, phone, marks, city, gender);
			}
			SqlUtil.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return student;
	}

	@Override
	public int remove(int id) {
		int result = -1;
		try {
			SqlUtil.connectDB();
			
			SqlUtil.statement = SqlUtil.connection.prepareStatement("delete from stud where id=?");
			SqlUtil.statement.setInt(1, id);
			result = SqlUtil.delete();			
			SqlUtil.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int update(int id, Student student) {
		int result = -1;
		try {
			SqlUtil.connectDB();
			
			SqlUtil.statement = SqlUtil.connection.prepareStatement("update stud set name=?,phone=?,marks=?,city=? where id=?");
			
			SqlUtil.statement.setString(1,student.getName());
			SqlUtil.statement.setString(2,student.getPhone());
			SqlUtil.statement.setFloat(3, student.getMarks());
			SqlUtil.statement.setString(4,student.getCity());
			
			SqlUtil.statement.setInt(5, id);
			result = SqlUtil.update();			
			SqlUtil.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
