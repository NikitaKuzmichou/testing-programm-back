package com.vsu.by.app.jpa.repository.attempt;

import com.vsu.by.app.jpa.model.attempt.Attempt;
import com.vsu.by.app.pupils.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Long> {

    void deleteAllByPupil(final Pupil pupil);

    List<Attempt> findAllByStart(final Date start);

    List<Attempt> findAllByEnd(final Date end);

    List<Attempt> findAllByMark(final Byte mark);
}
