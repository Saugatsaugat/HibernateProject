package com.saugat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String ar[]){
        SessionFactory sf =  new Configuration()
                .addAnnotatedClass(com.saugat.Employee.class)
                .configure()
                .buildSessionFactory(); //cfg.buildSessionFactory();

        Session session = sf.openSession();

        // fetching data
        Employee e1 = new Employee();
        e1 = session.get(Employee.class, 1);

        // closing resources
        session.close();
        sf.close();

        System.out.println(e1);
    }
}
