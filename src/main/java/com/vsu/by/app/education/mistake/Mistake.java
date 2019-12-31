package com.vsu.by.app.education.mistake;

import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import com.vsu.by.app.education.rule.Rule;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Mistake")
public class Mistake {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name="id_seq", sequenceName = "pupil_mistake_id", allocationSize = 1)
    private Long id;
    @ManyToOne
    private PupilAttempt pupilAttempt;
    @OneToOne
    private Rule rule;
    private int rowNo;
    private int colNo;
}
