package com.vsu.by.app.education.pupilattempt;

import com.vsu.by.app.people.pupils.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PupilAttemptRepository extends JpaRepository<PupilAttempt, Long> {

    List<PupilAttempt> findAllByPupil(Pupil pupil);

    List<PupilAttempt> findAllByPupilId(Long id);
}
