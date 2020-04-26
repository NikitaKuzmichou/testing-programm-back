package com.vsu.by.app.education.pupilmistake.dto;

import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptDetailDto;
import com.vsu.by.app.education.rule.dto.RuleDetailDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PupilMistakeDetailDto {
    private Long id;
    private PupilAttemptDetailDto pupilAttempt;
    private RuleDetailDto rule;
    private int wordNo;
    private int symbolNo;
}
