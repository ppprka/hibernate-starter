package com.innowise.danko.entity;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "record_book", schema = "studentsdatabase")
public class RecordBook extends BaseEntity {

    private String graduationYear;

    private Student student;

    private StudentGroup studentGroup;

    public RecordBook(){}

    public RecordBook(String graduationYear, Student student, StudentGroup studentGroup) {
        this.graduationYear = graduationYear;
        this.student = student;
        this.studentGroup = studentGroup;
    }

    /*@Id*/
    /*@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hibernateSeq")
    @SequenceGenerator(name="hibernateSeq", sequenceName="studentsdatabase.hibernate_sequence")*/
    /*@GeneratedValue*/

    @Column(name="graduation_year", table = "record_book")
    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    @OneToOne(optional = false, mappedBy = "recordBook")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id"/*, table = "student_group"*/)
    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }
}
