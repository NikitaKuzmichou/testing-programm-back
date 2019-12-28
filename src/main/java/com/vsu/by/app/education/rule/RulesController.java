package com.vsu.by.app.education.rule;

import com.vsu.by.app.education.rule.dto.RuleDetailDto;
import com.vsu.by.app.education.rule.dto.RuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("rules")
public class RulesController {
    @Autowired
    private RuleService ruleService;
    @Autowired
    private RuleMapper ruleMapper;
    private static final String VIEW_NAME = "/education/rule/rules";

    @GetMapping
    public ModelAndView getRules() {
        ModelAndView modelAndView = new ModelAndView(this.VIEW_NAME);
        modelAndView.addObject("rules",
                this.ruleMapper.toRuleInfoDto(this.ruleService.findAll()));
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getRule(@PathVariable("id") Long id) {
        Optional<Rule> rule = this.ruleService.getRule(id);
        if (rule.isPresent()) {
            ModelAndView modelAndView = new ModelAndView(this.VIEW_NAME);
            modelAndView.addObject("rule",
                    this.ruleMapper.toRuleDetailDto(rule.get()));
            return modelAndView;
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
