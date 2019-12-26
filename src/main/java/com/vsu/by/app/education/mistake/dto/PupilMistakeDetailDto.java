package com.vsu.by.app.education.mistake.dto;

import com.vsu.by.app.education.attempt.dto.AttemptDetailDto;
import com.vsu.by.app.education.rule.dto.RuleDetailDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PupilMistakeDetailDto {
    private Long id;
    private AttemptDetailDto attempt;
    private RuleDetailDto rule;
    private int rowNo;
    private int colNo;
}
