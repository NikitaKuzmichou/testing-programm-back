package com.vsu.by.app.jpa.repository.attempt;

import com.vsu.by.app.jpa.model.attempt.PupilError;
import com.vsu.by.app.jpa.repository.attempt.PupilErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PupilErrorService {

    @Autowired
    private PupilErrorRepository pupilErrorRepository;

    @Transactional(readOnly = true)
    public Optional<PupilError> getError(final Long id) {
        return this.pupilErrorRepository.findById(id);
    }

    @Transactional
    public PupilError saveError(final PupilError error) {
       return this.pupilErrorRepository.save(error);
    }

    @Transactional
    public void deleteError(final Long id) {
        this.pupilErrorRepository.deleteById(id);
    }

    @Transactional
    public PupilError updateError(final PupilError error) {
        return this.pupilErrorRepository.save(error);
    }

    @Transactional(readOnly = true)
    public List<PupilError> findAll() {
        return this.pupilErrorRepository.findAll();
    }
}
