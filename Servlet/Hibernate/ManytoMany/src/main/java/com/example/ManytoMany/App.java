package com.example.ManytoMany;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        
        Session session = new Configuration().configure().addAnnotatedClass(Actor.class).addAnnotatedClass(Role.class).buildSessionFactory().openSession();
        
        session.beginTransaction();
        
        Actor actor1 = new Actor();
        actor1.setId(1);
        actor1.setName("shraddha");
        actor1.setPhone("736674643");
        
        Actor actor2 = new Actor();
        actor2.setId(2);
        actor2.setName("tiger");
        actor2.setPhone("657654765");
        
        Role r1 = new Role();
        r1.setId(1);
        r1.setName("police");
        r1.setDescription("banduk leke khada hu aajaa");
        
        Role r2 = new Role();
        r2.setId(2);
        r2.setName("police");
        r2.setDescription("banduk leke khada hu aajaa");
        
        
        actor1.getListOfRoles().add(r1);
        actor1.getListOfRoles().add(r2);
        
        actor2.getListOfRoles().add(r1);
        
        r1.getListOfActors().add(actor1);
        r1.getListOfActors().add(actor2);
        
        r2.getListOfActors().add(actor1);
        
        session.persist(actor1);
        session.persist(actor2);
        session.persist(r1);
        session.persist(r2);
        
        session.getTransaction().commit();
    }
}
