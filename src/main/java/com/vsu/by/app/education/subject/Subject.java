package com.vsu.by.app.education.subject;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name="id_seq", sequenceName = "subject_id", allocationSize = 1)
    @Column(length = 32)
    private String name;
}
