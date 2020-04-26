package com.vsu.by.app.people.pupils;

import com.vsu.by.app.people.groups.Group;
import com.vsu.by.app.people.user.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "pupil_id")
public class Pupil extends User{
    @ManyToOne(optional = false, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "group_id")
    private Group group;
}
