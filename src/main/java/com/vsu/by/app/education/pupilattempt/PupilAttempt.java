package com.vsu.by.app.education.pupilattempt;

import com.vsu.by.app.education.attempt.Attempt;
import com.vsu.by.app.education.pupilmistake.PupilMistake;
import com.vsu.by.app.people.pupils.Pupil;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Data
@RequiredArgsConstructor
@Entity
public class PupilAttempt {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private Long id;
    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "pupil_id")
    private Pupil pupil;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Attempt attempt;
    @OneToMany(mappedBy = "pupilAttempt", cascade = {CascadeType.MERGE})
    private List<PupilMistake> pupilMistakes;
    private String text; /**TODO FOR DIPLOM*/
    private byte mark;

    public void addMistakes(Collection<PupilMistake> mistakes) {
        if (Objects.isNull(this.pupilMistakes)) {
            this.pupilMistakes = new LinkedList<>();
        }
        this.pupilMistakes.addAll(mistakes);
    }

    public void addMistake(PupilMistake pupilMistake) {
        if (Objects.isNull(this.pupilMistakes)) {
            this.pupilMistakes = new LinkedList<>();
        }
        this.pupilMistakes.add(pupilMistake);
    }
}
