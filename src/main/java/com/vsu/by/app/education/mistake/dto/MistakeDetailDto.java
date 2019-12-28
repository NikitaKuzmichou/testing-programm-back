package com.vsu.by.app.education.mistake.dto;

import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptDetailDto;
import com.vsu.by.app.education.rule.dto.RuleDetailDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MistakeDetailDto {
    private Long id;
    private PupilAttemptDetailDto pupilAttempt;
    private RuleDetailDto rule;
    private int rowNo;
    private int colNo;
}
