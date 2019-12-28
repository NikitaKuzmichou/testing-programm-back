package com.vsu.by.app.education.mistake;

import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import com.vsu.by.app.education.rule.Rule;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "mistake")
public class Mistake {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name="id_seq", sequenceName = "pupil_mistake_id", allocationSize = 1)
    private Long id;
    @ManyToOne
    private PupilAttempt pupilAttempt;
    @OneToOne
    private Rule rule;
    @Column(name = "row_no")
    private int rowNo;
    @Column(name = "col_no")
    private int colNo;
}
