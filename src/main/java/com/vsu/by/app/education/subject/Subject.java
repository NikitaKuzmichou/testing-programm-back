package com.vsu.by.app.education.subject;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Subject {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name="id_seq", sequenceName = "subject_id", allocationSize = 1)
    @Id private Long id;
    @Column(nullable = false, length = 32)
    private String name;
}
