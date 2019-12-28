package com.vsu.by.app.education.task;

import com.vsu.by.app.education.tasktype.TaskType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name="id_seq", sequenceName = "task_id", allocationSize = 1)
    private Long id;
    @Column(length = 64, nullable = false)
    private String name;
    @Embedded
    private TaskInfo info;
    @OneToOne(cascade = {CascadeType.ALL})
    private TaskType type;
    /**TODO FOR DIPLOM*/
    private String taskText;
}
