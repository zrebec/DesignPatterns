package sk.zrebec.learn.java.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        List<Horse> horseList = new ArrayList<>();

        // Alice horse
        Horse h = new Horse();
        h.addNewHorse("Alice", "Czech warmblood", 20120630);
        horseList.add(h);

        // Bolt horse
        h = new Horse();
        h.addNewHorse("Bolt", "Arabian horse", 20160726);
        horseList.add(h);

        // Lucky horse
        h = new Horse();
        h.addNewHorse("Lucky", "Appaloosa", 20041230);
        horseList.add(h);

        // Save horses into transaction
        Transaction tran = session.beginTransaction();
        for (Horse horse : horseList) {
            session.save(horse);
        }
        tran.commit();

        // Load horses from database
        Horse horse = session.get(Horse.class, 1L);
        System.out.println("Horse from database " + horse.getName());

        session.close();
        sf.close();
    }
}
