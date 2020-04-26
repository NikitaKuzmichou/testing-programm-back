package com.vsu.by.app.education.task;

import com.vsu.by.app.education.tasktype.TaskType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private Long id;
    @Column(length = 64, nullable = false)
    private String name;
    @Embedded
    private TaskInfo info;
    @OneToOne(cascade = {CascadeType.MERGE})
    private TaskType type;
    /**TODO FOR DIPLOM*/
    private String taskText;
}
