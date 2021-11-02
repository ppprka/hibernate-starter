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
@Table(name = "record_book", schema = "studentsdatabase")
public class RecordBook {

    @Id
    /*@SequenceGenerator(name="hibernateSeq", sequenceName = "HIBERNATE_SEQUENCE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernateSeq")*/
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="hibernateSeq")
    @SequenceGenerator(name="hibernateSeq",
            sequenceName="studentsdatabase.hibernate_sequence")
    private Long id;

    @Column(name="graduation_year")
    private String graduationYear;

    @Column(name="group_id")
    private Integer groupId;
}
