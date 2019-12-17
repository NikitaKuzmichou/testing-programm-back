package com.vsu.by.app.pupils;

import com.vsu.by.app.groups.Group;
import com.vsu.by.app.user.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@RequiredArgsConstructor
@Entity
public class Pupil {
    @OneToOne
    private User user;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Group group;
}
