package com.vsu.by.app.education.tasktype;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TaskType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name="id_seq", sequenceName = "task_type_id", allocationSize = 1)
    private Long id;
    private String name;
    /**TODO FOR DIPLOM*/
    @Column(name = "task_xsd")
    private String text;
    /**TODO FOR DIPLOM*/
    @Column(name = "result_xsd")
    private String result;
}
