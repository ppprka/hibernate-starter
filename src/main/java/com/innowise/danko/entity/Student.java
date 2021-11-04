package com.innowise.danko.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "student", schema = "studentsdatabase")
public class Student extends BaseEntity {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/

    private String name;
    private String surname;


    private RecordBook recordBook;


    private List<StudentGroup> studentGroups;

    public Student(){}

    public Student(String name, String surname, RecordBook recordBook, List<StudentGroup> studentGroups) {
        this.name = name;
        this.surname = surname;
        this.recordBook = recordBook;
        this.studentGroups = studentGroups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @OneToOne (optional = false/*, mappedBy = "record_book"*/, cascade = CascadeType.ALL)
    @JoinColumn (name = "id"/*,table = "record_book"*/)
    public RecordBook getRecordBook() {
        return recordBook;
    }

    public void setRecordBook(RecordBook recordBook) {
        this.recordBook = recordBook;
    }

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable (name = "enroll", joinColumns = {@JoinColumn (name = "id_group")},
            inverseJoinColumns = {@JoinColumn (name = "id_student")})
    public List<StudentGroup> getStudentGroups() {
        return studentGroups;
    }

    public void setStudentGroups(List<StudentGroup> studentGroups) {
        this.studentGroups = studentGroups;
    }
}
