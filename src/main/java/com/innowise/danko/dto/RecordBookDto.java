package com.innowise.danko.dto;

import com.innowise.danko.entity.Student;
import com.innowise.danko.entity.StudentGroup;
import lombok.Data;

@Data
public class RecordBookDto {

    private Long id;
    private String graduationYear;
    private String groupId;
    private StudentGroup studentGroup;
    private Student student;
}
