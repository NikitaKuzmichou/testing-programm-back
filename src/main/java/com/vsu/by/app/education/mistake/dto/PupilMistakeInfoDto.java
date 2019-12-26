package com.vsu.by.app.education.mistake.dto;

import com.vsu.by.app.education.attempt.dto.AttemptInfoDto;
import com.vsu.by.app.education.rule.dto.RuleInfoDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PupilMistakeInfoDto {
    private Long id;
    private AttemptInfoDto attempt;
    private RuleInfoDto rule;
    private int rowNo;
    private int colNo;
}
