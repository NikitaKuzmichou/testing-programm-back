package com.vsu.by.app.jpa.repository.attempt;

import com.vsu.by.app.jpa.model.attempt.PupilError;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PupilErrorRepository extends JpaRepository<PupilError, Long> {
}
