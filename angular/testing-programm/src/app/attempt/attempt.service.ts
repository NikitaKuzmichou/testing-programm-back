import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Attempt } from './attempt';
import { Task } from '../task/task';
import { Subject } from '../subject/subject';
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
}) export class AttemptService {
    private url: string;
    constructor(private http: HttpClient) {}

    setUrl(url: string) {
        this.url = url;
    }

    getAttempt(id: number): Attempt {
        const response = this.http.get<Attempt>(this.url + '/' + id);
        return this.parseToAttempt(response);
    }

    getAttempts(): Array<Attempt> {
        const response = this.http.get<Array<Attempt>>(this.url);
        return this.parseToListAttempts(response);
    }

    getStartAttempt(): Array<Attempt> {
      const response = this.http.get<Array<Attempt>>(this.url + '/start');
      return this.parseToListAttempts(response);
    }

    postAttempt(attempt: Attempt, groupId: number) {
        const response = this.http.post(this.url + '/' + groupId, attempt);
        let result;
        response.subscribe(res => {
            result = res;
        }, error => {
            console.error(error);
        });
        return result;
    }

    private parseToAttempt(observable: Observable<Attempt>): Attempt {
        const attempt: Attempt = new Attempt();
        observable.subscribe( item => {
            attempt.id = item.id;
            attempt.start = item.start;
            attempt.end = item.end;
            attempt.task = item.task;
            attempt.pupilsAttempts = item.pupilsAttempts;
        }, error => {
            console.error(error);
        });
        return attempt;
    }

    private parseToListAttempts(observable: Observable<Array<Attempt>>): Array<Attempt> {
        const attempts: Attempt[] = new Array<Attempt>();
        observable.subscribe( response => {
            response.map(item => {
                const attempt = new Attempt();
                attempt.id = item.id;
                attempt.start = item.start;
                attempt.end = item.end;
                attempt.task = item.task;
                attempt.pupilsAttempts = item.pupilsAttempts;
                attempts.push(attempt);
            });
        }, error => {
            console.error(error);
        });
        return attempts;
    }
}
