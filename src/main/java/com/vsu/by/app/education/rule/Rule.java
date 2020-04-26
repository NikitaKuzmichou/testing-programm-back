package com.vsu.by.app.education.rule;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Rule {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private Long id;
    @Column(length = 164, unique = true)
    private String name;
    private String description;
    @Column(length = 128)
    private String note;
}
