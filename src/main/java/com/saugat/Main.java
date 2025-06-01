package com.saugat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String ar[]){
        Employee em1 = new Employee();
        em1.setFirstname("Suresh");
        em1.setLastname("Khadka");
        em1.setAge(23);

        SessionFactory sf =  new Configuration()
                .addAnnotatedClass(com.saugat.Employee.class)
                .configure()
                .buildSessionFactory(); //cfg.buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        // save data
        session.persist(em1);

        transaction.commit();

        // closing resources
        session.close();
        sf.close();

        System.out.println("Data saved successfully");
    }
}
