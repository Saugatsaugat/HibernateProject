package com.saugat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String ar[]){
        Employee em1 = new Employee();
        em1.setFirstname("Saugat");
        em1.setMiddlename("Thapa");
        em1.setLastname("Thapa Chhetri");
        em1.setAge(24);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(com.saugat.Employee.class);
        cfg.configure();


        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();


        // save data
        session.save(em1);

        transaction.commit();

        System.out.println("Data saved successfully");
    }
}
