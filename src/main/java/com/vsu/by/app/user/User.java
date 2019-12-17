package com.vsu.by.app.user;

import com.vsu.by.app.role.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
public class User extends Person {
    @Column(length = 32, nullable = false, unique = true)
    private String login;
    @Column(length = 32, nullable = false)
    private String password;
    /*@ManyToMany
    @JoinTable(
            name = "User_roles",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")
            }
    )
    private List<Role> roles;
     */
    private Role role;
}
