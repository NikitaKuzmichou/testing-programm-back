package com.vsu.by.app.people.groups;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    List<Group> getAllByFacultyAndCourse(final String faculty, final Integer course);
}
