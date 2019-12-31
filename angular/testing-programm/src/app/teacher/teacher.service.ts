
import { HttpClient }         from '@angular/common/http';
import { Injectable }         from '@angular/core';
import { Observable }         from 'rxjs';
import { Teacher } from './teacher';

@Injectable({
    providedIn: 'root'
}) export class TeacherService {
    private url: string;
    constructor(private http: HttpClient) {}

    getTeacher(id: number): Teacher {
        var response = this.http.get<Teacher>(this.url + "/" + id);
        return this.parseToTeacher(response);
    }

    getTeachers(): Array<Teacher> {
        var response = this.http.get<Array<Teacher>>(this.url);
        return this.parseToListTeachers(response);
    }

    saveTeacher(teacher: Teacher) {
        var response = this.http.post<Teacher>(this.url, teacher);
        return this.parseToTeacher(response);
    }

    deleteTeacher(id: number) {
        var response;
        this.http.delete(this.url + "/" + id).subscribe(item => {
            response = item;
        }, error => {
            console.error(error);
        });
        return response;
    }

    private parseToTeacher(observable: Observable<Teacher>): Teacher {
        var teacher = new Teacher();
        observable.subscribe(item => {
            teacher.id = item.id;
            teacher.name = item.name;
            teacher.surname = item.surname;
            teacher.patronymic = item.patronymic;
            teacher.role = item.role;
            teacher.login = item.login;
            teacher.password = item.password;
        }, error => {
            console.error(error);
        });
        return teacher;
    }

    private parseToListTeachers(observable: Observable<Array<Teacher>>): Array<Teacher> {
        var teachers = new Array<Teacher>();
        observable.subscribe(response => {
            response.map(item => {
                var teacher = new Teacher();
                teacher.id = item.id;
                teacher.name = item.name;
                teacher.surname = item.surname;
                teacher.patronymic = item.patronymic;
                teacher.role = item.role;
                teacher.login = item.login;
                teacher.password = item.password;
                teachers.push(teacher);
            })
        }, error => {
            console.error(error);
        });
        return teachers;
    }
}