package com.vsu.by.app.education.pupilmistake.dto;

import com.vsu.by.app.education.rule.dto.RuleInfoDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PupilMistakeInfoDto {
    private Long id;
    private RuleInfoDto rule;
    private int wordNo;
    private int symbolNo;
}
