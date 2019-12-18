package com.vsu.by.app.education.task;

import com.vsu.by.app.education.subject.Subject;
import com.vsu.by.app.people.user.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public class TaskInfo {
    @Column(length = 64, nullable = false)
    private String name;
    @Column(length = 128, nullable = false)
    private String description;
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "teacher_id")
    private User uploader;
    @Column(length = 32, nullable = false, unique = true)
    private Subject subject;
}
