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
    @Embedded
    private TaskInfo info;
    @OneToMany(cascade = {CascadeType.ALL})
    private TaskType type;
    private Object taskText;
}
