package com.vsu.by.app.people.groups;

import com.vsu.by.app.people.pupils.Pupil;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Groups")
public class Group {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private Long id;
    @Column(nullable = false, unique = true)
    private int groupNo;
    @Column(nullable = false)
    private String faculty;
    @Column(nullable = false)
    private int course;
    @OneToMany(mappedBy = "group", cascade = {CascadeType.MERGE})
    private List<Pupil> pupils;
}
