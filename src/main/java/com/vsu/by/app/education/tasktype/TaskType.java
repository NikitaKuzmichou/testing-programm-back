package com.vsu.by.app.education.tasktype;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
/**TODO FOR DIPLOM*/
public class TaskType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name="id_seq", sequenceName = "task_type_id", allocationSize = 1)
    private Long id;
    private String name;
    @Column(name = "task_xsd")
    private Object text;
    @Column(name = "result_xsd")
    private Object result;
}
