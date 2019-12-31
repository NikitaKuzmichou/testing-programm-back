package com.vsu.by.app.education.rule;

import com.vsu.by.app.education.rule.dto.RuleDetailDto;
import com.vsu.by.app.education.rule.dto.RuleInfoDto;
import com.vsu.by.app.education.rule.dto.RuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("rules")
public class RulesController {
    @Autowired
    private RuleService ruleService;
    @Autowired
    private RuleMapper ruleMapper;

    @GetMapping
    public ResponseEntity<List<RuleInfoDto>> getRules() {
        return new ResponseEntity<>(
                this.ruleMapper.toRuleInfoDto(this.ruleService.findAll()),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RuleDetailDto> getRule(@PathVariable("id") Long id) {
        Optional<Rule> rule = this.ruleService.getRule(id);
        if (rule.isPresent()) {
            return new ResponseEntity<>(
                    this.ruleMapper.toRuleDetailDto(rule.get()),
                    HttpStatus.OK);
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого правила не существует");
        }
    }

    @PostMapping
    public ResponseEntity<String> addRule(@RequestBody RuleDetailDto ruleDetailDto) {
        this.ruleService.saveRule(this.ruleMapper.fromRuleDetailDto(ruleDetailDto));
        return new ResponseEntity<>("Saved", HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<String> updateRule(@RequestBody RuleDetailDto ruleDetailDto) {
        this.ruleService.saveRule(this.ruleMapper.fromRuleDetailDto(ruleDetailDto));
        return new ResponseEntity<>("Updated", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRule(@PathVariable("id") Long id) {
        this.ruleService.deleteRule(id);
        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
    }
}
