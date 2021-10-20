package com.HibernateMaven.MappingTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Laptop laptop =new Laptop();
       laptop.setLid(101);
       laptop.setLname("DELL");
       
       
       Student s = new Student();
       s.setName("Soni");
       s.setRollno(100);
       s.setMarks(80);
       s.getLaptop().add(laptop);
       
       laptop.getStudent().add(s);
       
    	Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class); 
    	
    	SessionFactory sf =con.buildSessionFactory();
    	
    	Session session=sf.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	
    	//session.save(alien); -- use to save the entry 
    	
    	/*
    	alien =(Alien)session.get(Alien.class, 102);      
    	
    System.out.println(alien); //print the fetched data 
  	*/
    	
    	session.save(s);
    	session.save(laptop);
    	
    	tx.commit();

    	
    }
}
