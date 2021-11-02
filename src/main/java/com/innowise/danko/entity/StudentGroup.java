package com.innowise.danko.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student_group", schema = "studentsdatabase")
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "course")
    @TableGenerator(
            name="course",
            table="GENERATOR_TABLE",
            schema = "studentsdatabase"
    )
    private Long id;

    private String number;
}
