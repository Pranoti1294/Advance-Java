package com.student.StudentHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.student.StudentHibernate.model.Student;


public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        Student std = new Student();
        std.setId(2);
        std.setName("onkar");
        std.setAddress("Solapur");
        std.setMarks(90);
        session.save(std);
        
        Student student = new Student();
        student.setId(3);
        student.setName("rohit");
        student.setAddress("Bengoluru");
        student.setMarks(87);
        session.save(student);
        
        transaction.commit();
        
        session.close();
    }
}
