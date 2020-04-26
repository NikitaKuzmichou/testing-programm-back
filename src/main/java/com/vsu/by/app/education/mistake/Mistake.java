package com.vsu.by.app.education.mistake;

import com.vsu.by.app.education.rule.Rule;
import com.vsu.by.app.education.task.Task;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Mistake")
public class Mistake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = {CascadeType.MERGE})
    private Rule rule;
    @OneToOne(cascade = {CascadeType.MERGE})
    private Task task;
    private int wordNo;
    private int symbolNo;
}
