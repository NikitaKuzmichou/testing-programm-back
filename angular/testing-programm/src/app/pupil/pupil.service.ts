import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pupil } from './pupil';

@Injectable({
    providedIn: 'root'
}) export class PupilService {
    private url: string;
    constructor(private http: HttpClient) {}

    setUrl(url: string) {
        this.url = url;
    }

    getPupil(id: number): Pupil {
        const response = this.http.get<Pupil>(this.url + '/' + id);
        return this.parseToPupil(response);
    }

    getPupils(): Array<Pupil> {
        const response = this.http.get<Array<Pupil>>(this.url);
        return this.parseToListPupils(response);
    }

    savePupil(pupil: Pupil) {
        const response = this.http.post<Pupil>(this.url, pupil);
        return this.parseToPupil(response);
    }

    deletePupil(id: number) {
        let response;
        this.http.delete(this.url + '/' + id).subscribe(item => {
            response = item;
        }, error => {
            console.error(error);
        });
        return response;
    }

    private parseToPupil(observable: Observable<Pupil>): Pupil {
        const pupil = new Pupil();
        observable.subscribe(item => {
            pupil.id = item.id;
            pupil.name = item.name;
            pupil.surname = item.surname;
            pupil.patronymic = item.patronymic;
            pupil.role = item.role;
            pupil.group = item.group;
            pupil.login = item.login;
            pupil.password = item.password;
        }, error => {
            console.error(error);
        });
        return pupil;
    }

    private parseToListPupils(observable: Observable<Array<Pupil>>): Array<Pupil> {
        const pupils = new Array<Pupil>();
        observable.subscribe(response => {
            response.map(item => {
                const pupil = new Pupil();
                pupil.id = item.id;
                pupil.name = item.name;
                pupil.surname = item.surname;
                pupil.patronymic = item.patronymic;
                pupil.role = item.role;
                pupil.group = item.group;
                pupil.login = item.login;
                pupil.password = item.password;
                pupils.push(pupil);
            });
        }, error => {
            console.error(error);
        });
        return pupils;
    }
}
