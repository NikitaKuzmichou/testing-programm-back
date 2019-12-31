
import { HttpClient }         from '@angular/common/http';
import { Injectable }         from '@angular/core';
import { Observable }         from 'rxjs';
import { PupilAttempt } from './pupilAttempt';

@Injectable({
    providedIn: 'root'
}) export class PupilAttemptService {
    private url: string;
    constructor(private http: HttpClient) {}

    setUrl(url: string) {
        this.url = url;
    }

    getPupilAttempt(pupilId: number, attemptId: number): PupilAttempt {
        var response = this.http.get<PupilAttempt>(this.url + "/" + pupilId + "/" + attemptId);
        return this.parseToPupilAttempt(response);
    }

    getPupilAttempts(): Array<PupilAttempt> {
        var response = this.http.get<Array<PupilAttempt>>(this.url);
        return this.parseToListPupilAttempts(response);
    }

    savePupilAttempt(pupilAttempt: PupilAttempt) {
        var response = this.http.post<PupilAttempt>(this.url + "/" + pupilAttempt.id + 
                                "/" + pupilAttempt.attempt.id, pupilAttempt);
        return this.parseToPupilAttempt(response);
    }

    updatePupilAttempt(pupilAttempt: PupilAttempt) {
        var response;
        this.http.put(this.url + "/" + pupilAttempt.id + 
                                    "/" + pupilAttempt.attempt.id, pupilAttempt).subscribe(
            item => {
                response = item;
            }, error => {
                console.error(error);
            });
        return response;
    }

    deletePupilAttempt(id: number) {
        var response;
        this.http.delete(this.url + "/" + id).subscribe(item => {
            response = item;
        }, error => {
            console.error(error);
        });
        return response;
    }

    private parseToPupilAttempt(observable: Observable<PupilAttempt>): PupilAttempt {
        var pupilAttempt = new PupilAttempt();
        observable.subscribe(item => {
            pupilAttempt.id = item.id;
            pupilAttempt.attempt = item.attempt;
            pupilAttempt.mark = item.mark;
            pupilAttempt.mistakes = item.mistakes;
            pupilAttempt.pupil = item.pupil;
            pupilAttempt.text = item.text;
        }, error => {
            console.error(error);
        });
        return pupilAttempt;
    }

    private parseToListPupilAttempts(observable: Observable<Array<PupilAttempt>>): Array<PupilAttempt> {
        var pupilAttempts = new Array<PupilAttempt>();
        observable.subscribe(response => {
            response.map(item => {
                var pupilAttempt = new PupilAttempt();
                pupilAttempt.id = item.id;
                pupilAttempt.attempt = item.attempt;
                pupilAttempt.mark = item.mark;
                pupilAttempt.mistakes = item.mistakes;
                pupilAttempt.pupil = item.pupil;
                pupilAttempt.text = item.text;
                pupilAttempts.push(pupilAttempt);
            })
        }, error => {
            console.error(error);
        });
        return pupilAttempts;
    }
}