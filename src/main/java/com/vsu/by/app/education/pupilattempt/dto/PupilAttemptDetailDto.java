package com.vsu.by.app.education.pupilattempt.dto;

import com.vsu.by.app.education.attempt.dto.AttemptDetailDto;
import com.vsu.by.app.education.pupilmistake.dto.PupilMistakeInfoDto;
import com.vsu.by.app.people.pupils.dto.PupilInfoDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class PupilAttemptDetailDto {
    private Long id;
    private PupilInfoDto pupil;
    private AttemptDetailDto attempt;
    private List<PupilMistakeInfoDto> mistakes;
    private String text; /**TODO FOR DIPLOM*/
    private byte mark;
}
