package com.innowise.danko;

import com.innowise.danko.entity.StudentGroup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

public class HibernateRunner {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        try(SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
            Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            /*Student student = Student.builder()
                    .name("Ivan")
                    .surname("Ivanov")
                    .build();
            session.save(student);*/

            /*RecordBook recordBook = RecordBook.builder()
                        .graduationYear("2020")
                        .groupId(2)
                        .build();
            session.save(recordBook);*/

            StudentGroup studentGroup = StudentGroup.builder()
                        .number("pepe")
                        .build();
            session.save(studentGroup);

            session.getTransaction().commit();
        }
    }
}
