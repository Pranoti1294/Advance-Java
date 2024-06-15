package com.example.firstMavenProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class App 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();	//created configuration file
    	configuration.configure().addAnnotatedClass(Product.class).addAnnotatedClass(Employee.class);	//load configuration file
    	SessionFactory sessionFactory = configuration.buildSessionFactory(); //through configuration method created sessionfactory object
    	Session session = sessionFactory.openSession();
    	Transaction transaction = session.beginTransaction();
    	
//    	 Product product = new Product();
//    	 product.setId(102);
//    	 product.setName("mouse");
//    	 product.setPrice(1400);
//    	 
//    	 session.save(product);
    	
//    	Employee employee = new Employee();
//    	employee.setId(1);
//    	employee.setName("pranoti");
//    	employee.setPhone("93567708");
//    	employee.setSalary(50000);
//    	
//    	session.save(employee);
    	
    	Employee employee = session.get(Employee.class, 1);
    	System.out.println(employee);
    	
    	 transaction.commit();
    }
}
