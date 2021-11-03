package com.innowise.danko.dto;

import com.innowise.danko.entity.RecordBook;
import com.innowise.danko.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class StudentGroupDto {

    private Long id;
    private String number;
    private List<Student> students;
    private List<RecordBook> recordBooks;
}
