package com.vsu.by.app.education.attempt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Long> {

    List<Attempt> findAllByStart(final Date start);

    List<Attempt> findAllByEnd(final Date end);
}
