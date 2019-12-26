package com.vsu.by.app.education.attempt;

import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import com.vsu.by.app.people.pupils.Pupil;
import com.vsu.by.app.education.task.Task;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name="id_seq", sequenceName = "attempt_id", allocationSize = 1)
    @Column(name = "attempt_id")
    private Long id;
    @OneToMany(mappedBy = "attempt", cascade = {CascadeType.ALL})
    private List<PupilAttempt> pupilsAttempts;
    @OneToOne
    private Task task;
    private Date start;
    private Date end;
}
