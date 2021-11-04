package com.innowise.danko;

import com.innowise.danko.dao.StudentDao;
import com.innowise.danko.dao.impl.RecordBookDaoImpl;
import com.innowise.danko.dao.impl.StudentDaoImpl;
import com.innowise.danko.dao.impl.StudentGroupDaoImpl;
import com.innowise.danko.entity.RecordBook;
import com.innowise.danko.entity.Student;
import com.innowise.danko.entity.StudentGroup;
import com.innowise.danko.service.RecordBookService;
import com.innowise.danko.service.StudentGroupService;
import com.innowise.danko.service.StudentService;
import com.innowise.danko.service.impl.RecordBookServiceImpl;
import com.innowise.danko.service.impl.StudentGroupServiceImpl;
import com.innowise.danko.service.impl.StudentServiceImpl;
import com.innowise.danko.util.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HibernateRunner {

    public static void main(String[] args) {
           StudentService studentService = new StudentServiceImpl(new StudentDaoImpl());
           StudentGroupService studentGroupService = new StudentGroupServiceImpl(new StudentGroupDaoImpl());
           RecordBookService recordBookService = new RecordBookServiceImpl(new RecordBookDaoImpl());
        Student student = Student.builder()
                        .surname("Paul")
                        .name("Danko")
                        .build();

        RecordBook recordBook = RecordBook.builder()
                .graduationYear("2022")
                .student(student)
                .build();
        student.setRecordBook(recordBook);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        List<RecordBook> recordBookList = new ArrayList<>();
        recordBookList.add(recordBook);
        StudentGroup studentGroup = StudentGroup.builder()
                        .number("M117")
                        .students(studentList)
                        .recordBooks(recordBookList)
                        .build();
        List<StudentGroup> studentGroupList = new ArrayList<>();
        studentGroupList.add(studentGroup);
        recordBook.setStudentGroup(studentGroup);
        student.setRecordBook(recordBook);
        student.setStudentGroups(studentGroupList);
        recordBookService.addRecordBook(recordBook);
        studentGroupService.addStudentGroup(studentGroup);
        studentService.addStudent(student);

    }
}
