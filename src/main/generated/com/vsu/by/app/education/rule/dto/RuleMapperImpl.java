package com.vsu.by.app.education.rule.dto;

import com.vsu.by.app.education.rule.Rule;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class RuleMapperImpl implements RuleMapper {

    @Override
    public Rule fromRuleDetailDto(RuleDetailDto ruleDetailDto) {
        if ( ruleDetailDto == null ) {
            return null;
        }

        Rule rule = new Rule();

        rule.setId( ruleDetailDto.getId() );
        rule.setName( ruleDetailDto.getName() );
        rule.setDescription( ruleDetailDto.getDescription() );
        rule.setNote( ruleDetailDto.getNote() );

        return rule;
    }

    @Override
    public Rule fromRuleInfoDto(RuleInfoDto ruleInfoDto) {
        if ( ruleInfoDto == null ) {
            return null;
        }

        Rule rule = new Rule();

        rule.setId( ruleInfoDto.getId() );
        rule.setName( ruleInfoDto.getName() );

        return rule;
    }

    @Override
    public RuleDetailDto toRuleDetailDto(Rule rule) {
        if ( rule == null ) {
            return null;
        }

        RuleDetailDto ruleDetailDto = new RuleDetailDto();

        ruleDetailDto.setId( rule.getId() );
        ruleDetailDto.setName( rule.getName() );
        ruleDetailDto.setDescription( rule.getDescription() );
        ruleDetailDto.setNote( rule.getNote() );

        return ruleDetailDto;
    }

    @Override
    public RuleInfoDto toRuleInfoDto(RuleInfoDto ruleInfoDto) {
        if ( ruleInfoDto == null ) {
            return null;
        }

        RuleInfoDto ruleInfoDto1 = new RuleInfoDto();

        ruleInfoDto1.setId( ruleInfoDto.getId() );
        ruleInfoDto1.setName( ruleInfoDto.getName() );

        return ruleInfoDto1;
    }

    @Override
    public List<RuleInfoDto> toRuleInfoDto(List<Rule> rules) {
        if ( rules == null ) {
            return null;
        }

        List<RuleInfoDto> list = new ArrayList<RuleInfoDto>( rules.size() );
        for ( Rule rule : rules ) {
            list.add( ruleToRuleInfoDto( rule ) );
        }

        return list;
    }

    protected RuleInfoDto ruleToRuleInfoDto(Rule rule) {
        if ( rule == null ) {
            return null;
        }

        RuleInfoDto ruleInfoDto = new RuleInfoDto();

        ruleInfoDto.setId( rule.getId() );
        ruleInfoDto.setName( rule.getName() );

        return ruleInfoDto;
    }
}
