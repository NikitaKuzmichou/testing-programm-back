package com.vsu.by.app.people.pupils;

import com.vsu.by.app.people.groups.Group;
import com.vsu.by.app.people.user.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
public class Pupil extends User{
    @ManyToOne(optional = false)
    @JoinColumn(insertable = false, updatable = false, name = "id")
    private Group group;
}
