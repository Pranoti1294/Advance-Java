package com.example.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Day1 {
	
	static Scanner sc = new Scanner(System.in);
	static Statement createCollection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dba", "root", "root");
			Statement st = conn.createStatement();
			return st;
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rollno, marks;
		String nm,add;
		
		Statement st = createCollection();
		int ch=0;
		 do{
			System.out.println("1.Insert   2.Update    3.Delete    4.Display    5.Exit");
			System.out.print("Enter choice : ");
			ch = sc.nextInt();
			
			switch(ch) {
			
			case 1:
				System.out.print("\nEnter Roll no : ");
				rollno = sc.nextInt();
				System.out.print("Enter name : ");
				sc.nextLine();
				nm = sc.nextLine();
				System.out.print("Enter address : ");
				add = sc.nextLine();
				System.out.print("Enter marks : ");
				marks = sc.nextInt();
				insert(st,rollno,nm,add,marks);
				break;
				
			case 2:
				System.out.print("\nEnter Roll no : ");
				rollno = sc.nextInt();
				System.out.print("Enter name : ");
				sc.nextLine();
				nm = sc.nextLine();
				System.out.print("Enter address : ");
				add = sc.nextLine();
				System.out.print("Enter marks : ");
				marks = sc.nextInt();
				update(st,rollno,nm,add,marks);
				break;
				
			case 3:
				System.out.print("\nEnter Roll no : ");
				rollno = sc.nextInt();
				delete(st,rollno);
				break;
				
			case 4:
				display(st);
				break;
				
			}
			
		}while(ch!=5);
		

	}

	private static void display(Statement st) {
		 String qry = "select * from student";

		    
		        try {
					ResultSet res = st.executeQuery(qry);
					System.out.println();
					while(res.next()) {
						int id = res.getInt("id");
						String nm = res.getString("name");
						int marks = res.getInt("marks");
						String add = res.getString("address");
						
						System.out.printf("%-5d%-20s%-20s%-20d\n",id,nm,add,marks);
						
					}
					System.out.println("\n");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		        

	}

	private static void delete(Statement st, int rollno) {
		
	    String qry = "DELETE from student WHERE id = '" + rollno + "'";

	    try {
	        int res = st.executeUpdate(qry);
	        if (res > 0)
	            System.out.println("One User Successfully Deleted\n");
	        else
	            System.out.println("ERROR OCCURRED :(\n");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	private static void update(Statement st, int rollno, String nm, String add, int marks) {
		
	    String qry = "UPDATE student SET name = '" + nm + "', address = '" + add + "', marks = " + marks + " WHERE id = " + rollno;

	    try {
	        int res = st.executeUpdate(qry);
	        if (res > 0) {
	            System.out.println("Record updated\n");
	        } else {
	            System.out.println("Record not updated\n");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	private static void insert(Statement st, int rollno, String nm, String add, int marks) {
		
		String qry = "insert into student values('"+rollno+"','"+nm+"','"+add+"','"+marks+"' )";
		try {
			int res = st.executeUpdate(qry);
			if(res>0) {
				System.out.println("Record inserted successfully\n");
			}
			else {
				System.out.println("Record not found\n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
