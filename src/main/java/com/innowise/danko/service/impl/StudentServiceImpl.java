package com.innowise.danko.service.impl;

import com.innowise.danko.dao.StudentDao;
import com.innowise.danko.entity.Student;
import com.innowise.danko.service.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
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
