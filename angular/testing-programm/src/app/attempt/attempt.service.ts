import { HttpClient }         from '@angular/common/http';
import { Injectable }         from '@angular/core';
import { Observable }         from 'rxjs';
import { Attempt }            from './attempt';

@Injectable({
    providedIn: 'root'
}) export class AttemptService {
    private url: string;
    constructor(private http: HttpClient) {}

    setUrl(url: string) {
        this.url = url;
    }

    getAttempt(id: number): Attempt {
        var response = this.http.get<Attempt>(this.url + "/" + id);
        return this.parseToAttempt(response);
    }

    getAttempts(): Array<Attempt> {
        var response = this.http.get<Array<Attempt>>(this.url);
        return this.parseToListAttempts(response);
    }

    postAttempt(attempt: Attempt) {
        var response = this.http.post(this.url, attempt);
        var result;
        response.subscribe(res => {
            result = res;
        }, error => {
            console.error(error);
        })
        return result;
    }

    private parseToAttempt(observable: Observable<Attempt>) {
        var attempt: Attempt = new Attempt();
        observable.subscribe( item => {
            attempt.id = item.id;
            attempt.start = item.start;
            attempt.end = item.end;
            if (item.pupilAttempts) {
                attempt.pupilAttempts = item.pupilAttempts;
            }
        }, error => {
            console.error(error);
        });
        return attempt;
    }

    private parseToListAttempts(observable: Observable<Array<Attempt>>) {
        var attempts: Attempt[] = new Array<Attempt>();
        observable.subscribe( response => {
            response.map( item => {
                var attempt = new Attempt();
                attempt.id = item.id;
                attempt.start = item.start;
                attempt.end = item.end;
                if (item.pupilAttempts) {
                    attempt.pupilAttempts = item.pupilAttempts;
                }
                attempts.push(attempt);
            })
        }, error => {
            console.error(error);
        });
        return attempts;
    }
}