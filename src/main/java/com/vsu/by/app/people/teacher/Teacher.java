package com.vsu.by.app.people.teacher;

import com.vsu.by.app.people.user.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data
@RequiredArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Teacher extends User {
}
