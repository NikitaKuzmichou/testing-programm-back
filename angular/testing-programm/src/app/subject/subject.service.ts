
import { HttpClient }         from '@angular/common/http';
import { Injectable }         from '@angular/core';
import { Observable }         from 'rxjs';
import { Subject } from './subject';

@Injectable({
    providedIn: 'root'
}) export class SubjectService {
    private url: string;
    constructor(private http: HttpClient) {}

    setUrl(url: string) {
        this.url = url;
    }

    getSubject(id: number): Subject {
        var response = this.http.get<Subject>(this.url + "/" + id);
        return this.parseToSubject(response);
    }

    getSubjects(): Array<Subject> {
        var response = this.http.get<Array<Subject>>(this.url);
        return this.parseToListSubjects(response);
    }

    saveSubject(subject: Subject) {
        var response = this.http.post<Subject>(this.url, subject);
        return this.parseToSubject(response);
    }

    deleteSubject(id: number) {
        var response;
        this.http.delete(this.url + "/" + id).subscribe(item => {
            response = item;
        }, error => {
            console.error(error);
        });
        return response;
    }

    private parseToSubject(observable: Observable<Subject>): Subject {
        var subject = new Subject();
        observable.subscribe(item => {
            subject.id = item.id;
            subject.name = item.name;
        }, error => {
            console.error(error);
        });
        return subject;
    }

    private parseToListSubjects(observable: Observable<Array<Subject>>): Array<Subject> {
        var pupils = new Array<Subject>();
        observable.subscribe(response => {
            response.map(item => {
                var subject = new Subject();
                subject.id = item.id;
                subject.name = item.name;
                pupils.push(subject);
            })
        }, error => {
            console.error(error);
        });
        return pupils;
    }
}