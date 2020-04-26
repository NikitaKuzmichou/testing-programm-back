package com.vsu.by.app.education.tasktype;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TaskType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private Long id;
    private String name;
}
