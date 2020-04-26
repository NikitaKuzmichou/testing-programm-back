package com.vsu.by.app.people.user;

import com.vsu.by.app.role.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
/*@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.INTEGER,
        name = "user_type",
        columnDefinition = "TINYINT(1)"
)
 */
public class User extends Person {
    @Column(length = 32, nullable = false, unique = true)
    private String login;
    @Column(length = 32, nullable = false)
    private String password;
    @OneToOne(cascade = {CascadeType.MERGE})
    private Role role;
}
