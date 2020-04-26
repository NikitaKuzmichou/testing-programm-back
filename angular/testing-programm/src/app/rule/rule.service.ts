import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Rule } from './rule';

@Injectable({
  providedIn: 'root'
}) export class RuleService {
  private url: string;
  constructor(private http: HttpClient) {}

  setUrl(url: string) {
    this.url = url;
  }

  getRule(id: number): Rule {
    const response = this.http.get<Rule>(this.url + '/' + id);
    return this.parseToRule(response);
  }

  getRules(): Array<Rule> {
    const response = this.http.get<Array<Rule>>(this.url);
    return this.parseToListRules(response);
  }

  updateRule(rule: Rule): Rule {
    const response = this.http.put<Rule>(this.url, rule);
    return this.parseToRule(response);
  }

  saveRule(rule: Rule): Rule {
    const response = this.http.post<Rule>(this.url, rule);
    return this.parseToRule(response);
  }

  deleteRule(id: number) {
    let response;
    this.http.delete(this.url + '/' + id).subscribe(item => {
      response = item;
    }, error => {
      console.error(error);
    });
    return response;
  }

  private parseToRule(observable: Observable<Rule>): Rule {
    const rule = new Rule();
    observable.subscribe(item => {
      rule.id = item.id;
      rule.description = item.description;
      rule.name = item.name;
      rule.note = item.note;
    }, error => {
      console.error(error);
    });
    return rule;
  }

  private parseToListRules(observable: Observable<Array<Rule>>): Array<Rule> {
    const rules = new Array<Rule>();
    observable.subscribe(response => {
      response.map(item => {
        const rule = new Rule();
        rule.id = item.id;
        rule.description = item.description;
        rule.name = item.name;
        rule.note = item.note;
      });
    }, error => {
      console.error(error);
    });
    return rules;
  }
}
