package com.vsu.by.app.education.mistake;

import com.vsu.by.app.education.attempt.Attempt;
import lombok.Data;

import com.vsu.by.app.education.rule.Rule;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pupil_mistake")
public class PupilMistake {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name="id_seq", sequenceName = "pupil_mistake_id", allocationSize = 1)
    private Long id;
    @OneToOne(cascade = {CascadeType.ALL})
    private Attempt attempt;
    @OneToOne
    private Rule rule;
    @Column(name = "row_no")
    private int rowNo;
    @Column(name = "col_no")
    private int colNo;
}
