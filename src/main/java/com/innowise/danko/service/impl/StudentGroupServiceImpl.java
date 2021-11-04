package com.innowise.danko.service.impl;

import com.innowise.danko.dao.StudentGroupDao;
import com.innowise.danko.entity.StudentGroup;
import com.innowise.danko.service.StudentGroupService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StudentGroupServiceImpl implements StudentGroupService {

    private final StudentGroupDao studentGroupDao;

    public StudentGroupServiceImpl(StudentGroupDao studentGroupDao) {
        this.studentGroupDao = studentGroupDao;
    }


    @Override
    public void addStudentGroup(StudentGroup studentGroup) {
        studentGroupDao.save(studentGroup);
    }
}
