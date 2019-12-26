package com.vsu.by.app.education.pupilattempt.dto;

import com.vsu.by.app.education.attempt.dto.AttemptDetailDto;
import com.vsu.by.app.people.pupils.dto.PupilInfoDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PupilAttemptDetailDto {
    private Long id;
    private PupilInfoDto pupil;
    private AttemptDetailDto attempt;
    private String text; /**TODO FOR DIPLOM*/
    private byte mark;
}
