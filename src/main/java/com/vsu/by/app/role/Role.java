package com.vsu.by.app.role;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name="id_seq", sequenceName = "role_id", allocationSize = 1)
    @Id private Long id;
    /**Possible roles: ADMIN, TEACHER, PUPIL*/
    private String name;
    //@ManyToMany(mappedBy = "roles")
    //private List<User> users;
}
