package com.vsu.by.app.people.teacher;

import com.vsu.by.app.people.user.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "id")
/*@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("2")
 */
public class Teacher extends User {
}
