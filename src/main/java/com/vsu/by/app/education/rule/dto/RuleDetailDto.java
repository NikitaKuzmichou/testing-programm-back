package com.vsu.by.app.education.rule.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RuleDetailDto {
    private Long id;
    private String name;
    private String description;
    private String note;
}
