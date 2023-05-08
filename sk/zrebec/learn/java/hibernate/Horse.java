package sk.zrebec.learn.java.hibernate;

/**
 * This class using ORM for better manipulation of database (sqlite3 in my case)
 * Usually I want use here record instead of class because record it's ideal
 * for persistent data save. But record it's still new thing and later can be
 * refactored for Record. But for now I'm using rather lombok which is more
 * compatible for this case because I'm not use how state is JDBC connector
 * in Maven for SQLITE3.
 */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Horse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String breed;
    private long birthdate;

    public void addNewHorse(String name, String breed, long birthdate) {
        this.name = name;
        this.breed = breed;
        this.birthdate = birthdate;

        System.out.println(this.name);
    }
}
