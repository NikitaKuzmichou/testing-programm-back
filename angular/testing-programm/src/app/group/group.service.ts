import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Group } from './group';

@Injectable({
    providedIn: 'root'
}) export class GroupService {
    private url: string;
    constructor(private http: HttpClient) {}

    setUrl(url: string) {
        this.url = url;
    }

    getGroup(id: number): Group {
        const response = this.http.get<Group>(this.url + '/' + id);
        return this.parseToGroup(response);
    }

    getFaculties(facultyUrl: string): Array<string> {
        const response = this.http.get<Array<string>>(this.url + '/' + facultyUrl);
        return this.parseToListFaculties(response);
    }

    getCourses(faculty: string, coursesUrl: string): Array<number> {
        const response = this.http.get<Array<number>>(this.url + '/' + faculty + '/' + coursesUrl);
        return this.parseToListCourses(response);
    }

    getGroupsByFacultyAndCourse(faculty: string, course: number): Array<Group> {
        const response = this.http.get<Array<Group>>(this.url + '/' + faculty + '/' + course);
        return this.parseToListGroups(response);
    }

    getGroups(): Array<Group> {
        const response = this.http.get<Array<Group>>(this.url);
        return this.parseToListGroups(response);
    }

    saveGroup(group: Group) {
        const response = this.http.post<Group>(this.url, group);
        return this.parseToGroup(response);
    }

    deleteGroup(id: number) {
        let response;
        this.http.delete(this.url + '/' + id).subscribe(item => {
            response = item;
        }, error => {
            console.error(error);
        });
        return response;
    }

    private parseToGroup(observable: Observable<Group>): Group {
        const group = new Group();
        observable.subscribe(item => {
            group.id = item.id;
            group.course = item.course;
            group.faculty = item.faculty;
            group.groupNo = item.groupNo;
            if (item.pupils) {
                group.pupils = item.pupils;
            }
        }, error => {
            console.error(error);
        });
        return group;
    }

    private parseToListFaculties(observable: Observable<Array<string>>): Array<string> {
        const faculties = new Array<string>();
        observable.subscribe(response => {
            response.map(item => {
                faculties.push(item);
            });
        }, error => {
            console.error(error);
        });
        return faculties;
    }

    private parseToListCourses(observable: Observable<Array<number>>): Array<number> {
        const courses = new Array<number>();
        observable.subscribe(response => {
            response.map(item => {
                courses.push(item);
            });
        }, error => {
            console.error(error);
        });
        return courses;
    }

    private parseToListGroups(observable: Observable<Array<Group>>): Array<Group> {
        const pupils = new Array<Group>();
        observable.subscribe(response => {
            response.map(item => {
                const group = new Group();
                group.id = item.id;
                group.course = item.course;
                group.faculty = item.faculty;
                group.groupNo = item.groupNo;
                if (item.pupils) {
                    group.pupils = item.pupils;
                }
                pupils.push(group);
            });
        }, error => {
            console.error(error);
        });
        return pupils;
    }
}
