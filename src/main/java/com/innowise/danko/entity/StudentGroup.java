package com.innowise.danko.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "student_group", schema = "studentsdatabase")
public class StudentGroup extends BaseEntity {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    /*@GeneratedValue(strategy = GenerationType.TABLE, generator = "course")
    @TableGenerator(
            name="course",
            table="GENERATOR_TABLE",
            schema = "studentsdatabase"
    )*/

    private String number;

    private List<Student> students;


    private List<RecordBook> recordBooks;

    public StudentGroup(){}

    public StudentGroup(String number, List<Student> students, List<RecordBook> recordBooks) {
        this.number = number;
        this.students = students;
        this.recordBooks = recordBooks;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @ManyToMany(mappedBy = "studentGroups")
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @OneToMany (targetEntity = RecordBook.class ,mappedBy = "studentGroup",
                cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<RecordBook> getRecordBooks() {
        return recordBooks;
    }

    public void setRecordBooks(List<RecordBook> recordBooks) {
        this.recordBooks = recordBooks;
    }
}
