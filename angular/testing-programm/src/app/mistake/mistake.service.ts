import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Mistake } from './mistake';

@Injectable({
  providedIn: 'root'
}) export class MistakeService {
  private url: string;
  constructor(private http: HttpClient) {}

  setUrl(url: string) {
    this.url = url;
  }

  getPupilMistakes(pupilAttemptId: number): Array<Mistake> {
    const response = this.http.get<Array<Mistake>>(this.url + '/' + pupilAttemptId);
    return this.parseToListMistakes(response);
  }

  getMistakes(): Array<Mistake> {
    const response = this.http.get<Array<Mistake>>(this.url);
    return this.parseToListMistakes(response);
  }

  updateMistake(rule: Mistake): Mistake {
    const response = this.http.put<Mistake>(this.url, rule);
    return this.parseToMistake(response);
  }

  saveMistake(rule: Mistake): Mistake {
    const response = this.http.post<Mistake>(this.url, rule);
    return this.parseToMistake(response);
  }

  deleteMistake(id: number) {
    let response;
    this.http.delete(this.url + '/' + id).subscribe(item => {
      response = item;
    }, error => {
      console.error(error);
    });
    return response;
  }

  private parseToMistake(observable: Observable<Mistake>): Mistake {
    const mistake = new Mistake();
    observable.subscribe(item => {
      mistake.id = item.id;
      mistake.rule = item.rule;
      mistake.symbolNo = item.symbolNo;
      mistake.wordNo = item.wordNo;
      mistake.pupilAttempt = item.pupilAttempt;
    }, error => {
      console.error(error);
    });
    return mistake;
  }

  private parseToListMistakes(observable: Observable<Array<Mistake>>): Array<Mistake> {
    const mistakes = new Array<Mistake>();
    observable.subscribe(response => {
      response.map(item => {
        const mistake = new Mistake();
        mistake.id = item.id;
        mistake.rule = item.rule;
        mistake.symbolNo = item.symbolNo;
        mistake.wordNo = item.wordNo;
        mistake.pupilAttempt = item.pupilAttempt;
        mistakes.push(mistake);
      });
    }, error => {
      console.error(error);
    });
    return mistakes;
  }
}
