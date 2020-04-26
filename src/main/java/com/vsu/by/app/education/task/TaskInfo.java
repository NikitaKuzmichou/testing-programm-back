package com.vsu.by.app.education.task;

import com.vsu.by.app.education.subject.Subject;
import com.vsu.by.app.people.teacher.Teacher;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Data
@RequiredArgsConstructor
@Embeddable
public class TaskInfo {
    @Column(length = 128, nullable = false)
    private String description;
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Teacher teacher;
    @OneToOne(cascade = {CascadeType.REFRESH})
    private Subject subject;

}
