package com.vsu.by.app.people.user;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name="id_seq", sequenceName = "person_id", allocationSize = 1)
    @Column(insertable = false, updatable = false)
    @Id private Long id;
    @Column(length = 16, nullable = false)
    private String name;
    @Column(length = 26, nullable = false)
    private String surname;
    @Column(length = 26)
    private String patronymic;
}
