package com.vsu.by.app.jpa.model.attempt;

import com.vsu.by.app.people.pupils.Pupil;
import com.vsu.by.app.education.task.Task;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name="id_seq", sequenceName = "attempt_id", allocationSize = 1)
    private Long id;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private Pupil pupil;
    @OneToOne
    private Task task;
    private Date start;
    private Date end;
    private Object pupilAttempt; /**TODO FOR DIPLOM*/
    private byte mark;
}
