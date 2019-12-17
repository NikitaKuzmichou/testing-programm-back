package com.vsu.by.app.role;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name="id_seq", sequenceName = "role_id", allocationSize = 1)
    private Long id;
    /**Possible roles: ADMIN, TEACHER, PUPIL*/
    private String name;
    //@ManyToMany(mappedBy = "roles")
    //private List<User> users;
}
