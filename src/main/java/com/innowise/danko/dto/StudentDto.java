package com.innowise.danko.dto;

import com.innowise.danko.entity.RecordBook;
import com.innowise.danko.entity.StudentGroup;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {

    private Long id;
    private String name;
    private String surname;
    private RecordBook recordBook;
    private List<StudentGroup> studentGroup;
}
