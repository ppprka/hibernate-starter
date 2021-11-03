package com.innowise.danko.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student", schema = "studentsdatabase")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @OneToOne (optional = false, mappedBy = "record_book")
    @JoinColumn (name = "id", table = "record_book")
    private RecordBook recordBook;

    @ManyToMany
    @JoinTable (name = "enroll", joinColumns = @JoinColumn (name = "id_group"),
                inverseJoinColumns = @JoinColumn (name = "id_student"))
    private List<StudentGroup> studentGroups;
}
