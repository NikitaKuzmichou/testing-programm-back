package com.vsu.by.app.education.pupilattempt.dto;

import com.vsu.by.app.people.pupils.dto.PupilInfoDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PupilAttemptDto {
    private Long id;
    private PupilInfoDto pupil;
    private byte mark;
}
