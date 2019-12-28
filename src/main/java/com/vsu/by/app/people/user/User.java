package com.vsu.by.app.people.user;

import com.vsu.by.app.role.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User extends Person {
    @Column(length = 32, nullable = false, unique = true)
    private String login;
    @Column(length = 32, nullable = false)
    private String password;
    @OneToOne
    private Role role;
}
