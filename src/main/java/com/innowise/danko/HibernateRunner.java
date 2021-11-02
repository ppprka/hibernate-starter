package com.innowise.danko;

import com.innowise.danko.entity.RecordBook;
import com.innowise.danko.entity.Student;
import com.innowise.danko.entity.StudentGroup;
import com.innowise.danko.entity.User;
import com.innowise.danko.util.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.time.LocalDate;

public class HibernateRunner {

    public static void main(String[] args) throws SQLException {
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
