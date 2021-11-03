package com.innowise.danko.service.impl;

import com.innowise.danko.dao.StudentDao;
import com.innowise.danko.entity.Student;
import com.innowise.danko.service.StudentService;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;
    private final SessionFactory sessionFactory;

    public StudentServiceImpl(StudentDao studentDao, SessionFactory sessionFactory) {
        this.studentDao = studentDao;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addStudent(Student student) {
        studentDao.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.saveOrUpdate(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }
}
