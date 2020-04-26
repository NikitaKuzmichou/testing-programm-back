package com.vsu.by.app.education.attempt;

import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import com.vsu.by.app.education.task.Task;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
public class Attempt {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private Long id;
    @OneToMany(mappedBy = "attempt", cascade = {CascadeType.MERGE})
    private List<PupilAttempt> pupilsAttempts;
    @OneToOne
    private Task task;
    private Long start;
    private Long end;
}
