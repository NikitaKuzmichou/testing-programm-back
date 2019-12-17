package com.vsu.by.app.groups;

import com.vsu.by.app.pupils.Pupil;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name="id_seq", sequenceName = "group_id", allocationSize = 1)
    private Long id;
    @Column(nullable = false, unique = true)
    private int groupNo;
    @Column(nullable = false)
    private String faculty;
    @Column(nullable = false)
    private int course;
    @OneToMany(cascade = {CascadeType.REFRESH})
    private List<Pupil> pupils;
}
