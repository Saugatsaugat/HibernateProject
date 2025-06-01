package com.saugat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String ar[]){

        Employee e1 = new Employee();
        Employee e2 = new Employee();

        e2.setFirstname("Saugat");
        e2.setLastname("Thapa");
        e2.setAge(30);
        e2.setId(1);

        SessionFactory sf =  new Configuration()
                .addAnnotatedClass(com.saugat.Employee.class)
                .configure()
                .buildSessionFactory(); //cfg.buildSessionFactory();

        Session session = sf.openSession();

        // fetching data
        e1 = session.get(Employee.class, 2);

        Transaction transaction = session.beginTransaction();

        //updating data
        session.merge(e2);
        session.remove(e1);

        transaction.commit();

        // closing resources
        session.close();
        sf.close();

        System.out.println(e1);
    }
}
