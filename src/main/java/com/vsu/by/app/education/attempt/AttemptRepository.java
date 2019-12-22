package com.vsu.by.app.education.attempt;

import com.vsu.by.app.people.pupils.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Long> {

    Optional<Attempt> findByIdAndByPupil(final Long id, final Pupil pupil);

    List<Attempt> findAllByPupil(final Pupil pupil);

    void deleteAllByPupil(final Pupil pupil);

    List<Attempt> findAllByStart(final Date start);

    List<Attempt> findAllByEnd(final Date end);

    List<Attempt> findAllByMark(final Byte mark);
}
