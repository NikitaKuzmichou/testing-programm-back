package com.vsu.by.app.people.pupils;

import com.vsu.by.app.people.groups.Group;
import com.vsu.by.app.people.user.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@RequiredArgsConstructor
@Entity
public class Pupil extends User{
    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Group group;
}
