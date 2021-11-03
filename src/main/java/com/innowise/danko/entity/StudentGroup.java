package com.innowise.danko.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student_group", schema = "studentsdatabase")
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*@GeneratedValue(strategy = GenerationType.TABLE, generator = "course")
    @TableGenerator(
            name="course",
            table="GENERATOR_TABLE",
            schema = "studentsdatabase"
    )*/
    private Long id;

    private String number;

    @ManyToMany
    @JoinTable (name="enroll", joinColumns = @JoinColumn (name = "id_student"),
                inverseJoinColumns = @JoinColumn (name = "id_group"))
    private List<Student> students;

    @OneToMany (mappedBy = "studentGroup", fetch = FetchType.EAGER)
    private List<RecordBook> recordBooks;
}
