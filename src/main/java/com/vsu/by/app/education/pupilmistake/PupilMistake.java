package com.vsu.by.app.education.pupilmistake;

import com.vsu.by.app.education.mistake.Mistake;
import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Pupil_Mistake")
public class PupilMistake {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private Long id;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private PupilAttempt pupilAttempt;
    @OneToOne(cascade = {CascadeType.MERGE})
    private Mistake mistake;
    private int wordNo;
    private int symbolNo;
}
