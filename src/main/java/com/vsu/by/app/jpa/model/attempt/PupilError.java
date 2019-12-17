package com.vsu.by.app.jpa.model.attempt;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pupil_error")
public class PupilError {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name="id_seq", sequenceName = "pupil_error_id", allocationSize = 1)
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
