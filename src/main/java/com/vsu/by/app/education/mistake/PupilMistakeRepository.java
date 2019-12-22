package com.vsu.by.app.education.mistake;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PupilMistakeRepository extends JpaRepository<PupilMistake, Long> {
}
