package com.vsu.by.app.education.rule;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name="id_seq", sequenceName = "rule_id", allocationSize = 1)
    private Long id;
    @Column(length = 164, unique = true)
    private String name;
    private String description;
    @Column(length = 128)
    private String note;
}
