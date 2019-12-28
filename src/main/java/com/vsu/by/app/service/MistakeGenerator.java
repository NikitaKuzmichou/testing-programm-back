package com.vsu.by.app.service;

import com.vsu.by.app.education.attempt.Attempt;
import com.vsu.by.app.education.mistake.Mistake;
import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import com.vsu.by.app.education.rule.Rule;
import com.vsu.by.app.education.rule.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MistakeGenerator {
    @Autowired
    private RuleService ruleService;

    public Mistake getMistake(PupilAttempt pupilAttempt, int col, int row) {
        Mistake mistake = this.getMistakeWithoutRule(pupilAttempt, col, row);
        mistake.setRule(this.getMistakeRule(pupilAttempt.getAttempt(), col, row));
        return mistake;
    }

    public Mistake getMistake(PupilAttempt pupilAttempt, int col, int row, String ruleName) {
        Mistake mistake = this.getMistakeWithoutRule(pupilAttempt, col, row);
        Rule rule = ruleService.getRule(ruleName);
        if (Objects.isNull(rule)) {
            rule = new Rule();
            rule.setName(ruleName);
        }
        mistake.setRule(rule);
        return mistake;
    }

    /**TODO REMOVE??*/
    public Mistake getDifferentLengthMistake(PupilAttempt pupilAttempt) {
        Mistake mistake = this.getMistakeWithoutRule(pupilAttempt, 0, 0);
        Rule rule = ruleService.getRule("Ошибка длины ответа");
        if (Objects.isNull(rule)) {
            rule = new Rule();
            rule.setName("Ошибка длины ответа");
            rule.setDescription("Длина ответа не совпадает с длиной задания");
            rule.setDescription("Ошибка возникает в том случае, " +
                    "если длина написанного учеником задания, не совпадает с длиной задания");
        }
        mistake.setRule(rule);
        return mistake;
    }

    private Mistake getMistakeWithoutRule(PupilAttempt pupilAttempt, int col, int row) {
        Mistake mistake = new Mistake();
        mistake.setPupilAttempt(pupilAttempt);
        mistake.setColNo(col);
        mistake.setRowNo(row);
        return mistake;
    }

    /**TODO NEW MISTAKE LOGIC FOR DIPLOM*/
    private Rule getMistakeRule(Attempt attempt, int col, int row) {
        return null;
    }
}
