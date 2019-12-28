package com.vsu.by.app.education.mistake.dto;

import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptInfoDto;
import com.vsu.by.app.education.rule.dto.RuleInfoDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MistakeAddEditDto {
    private Long id;
    private PupilAttemptInfoDto pupilAttempt;
    private RuleInfoDto rule;
    private int rowNo;
    private int colNo;
}
