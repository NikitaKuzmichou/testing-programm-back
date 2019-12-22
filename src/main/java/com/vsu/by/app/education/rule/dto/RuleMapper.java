package com.vsu.by.app.education.rule.dto;

import com.vsu.by.app.education.rule.Rule;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RuleMapper {

    RuleMapper INSTANCE = Mappers.getMapper(RuleMapper.class);

    Rule fromRuleDetailDto(RuleDetailDto ruleDetailDto);

    Rule fromRuleInfoDto(RuleInfoDto ruleInfoDto);

    RuleDetailDto toRuleDetailDto(Rule rule);

    RuleInfoDto toRuleInfoDto(RuleInfoDto ruleInfoDto);

    List<RuleInfoDto> toRuleInfoDto(List<Rule> rules);
}
