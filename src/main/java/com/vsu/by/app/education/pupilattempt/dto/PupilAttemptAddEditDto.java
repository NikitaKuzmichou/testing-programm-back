package com.vsu.by.app.education.pupilattempt.dto;

import com.vsu.by.app.education.attempt.dto.AttemptInfoDto;
import com.vsu.by.app.people.pupils.dto.PupilInfoDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PupilAttemptAddEditDto {
    private Long id;
    private PupilInfoDto pupil;
    private AttemptInfoDto attempt;
    private String text; /**TODO FOR DIPLOM*/
    private byte mark;
}
