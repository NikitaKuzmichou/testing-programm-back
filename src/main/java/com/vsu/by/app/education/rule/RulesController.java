package com.vsu.by.app.education.rule;

import com.vsu.by.app.education.rule.dto.RuleDetailDto;
import com.vsu.by.app.education.rule.dto.RuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("rules/")
public class RulesController {
    @Autowired
    private RuleService ruleService;
    @Autowired
    private RuleMapper ruleMapper;

    @GetMapping
    public String getRules(Model model) {
        model.addAttribute("rules",
                this.ruleMapper.toRuleInfoDto(this.ruleService.findAll()));
        return "Currently added rules";
    }

    @GetMapping("/{id}")
    public String getRule(@PathVariable("id") Long id, Model model) {
        Optional<Rule> rule = this.ruleService.getRule(id);
        if (rule.isPresent()) {
            model.addAttribute("rule",
                    this.ruleMapper.toRuleDetailDto(rule.get()));
            return "Rule info";
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого правила не существует");
        }
    }

    @PostMapping("/add/")
    public String addRule(@RequestBody RuleDetailDto ruleDetailDto) {
        this.ruleService.saveRule(this.ruleMapper.fromRuleDetailDto(ruleDetailDto));
        return "Saved";
    }

    @PostMapping("/update/")
    public String updateRule(@RequestBody RuleDetailDto ruleDetailDto) {
        this.ruleService.saveRule(this.ruleMapper.fromRuleDetailDto(ruleDetailDto));
        return "Updated";
    }

    @GetMapping("/delete/{id}")
    public String deleteRule(@PathVariable("id") Long id) {
        this.ruleService.deleteRule(id);
        return "Deleted";
    }
}
