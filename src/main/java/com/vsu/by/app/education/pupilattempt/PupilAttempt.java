package com.vsu.by.app.education.pupilattempt;

import com.vsu.by.app.education.attempt.Attempt;
import com.vsu.by.app.people.pupils.Pupil;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
public class PupilAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name="id_seq", sequenceName = "pupil_attempt_id", allocationSize = 1)
    private Long id;
    @OneToOne
    private Pupil pupil;
    @ManyToOne
    private Attempt attempt;
    private Object text; /**TODO FOR DIPLOM*/
    private byte mark;
}