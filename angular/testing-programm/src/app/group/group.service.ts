
import { HttpClient }         from '@angular/common/http';
import { Injectable }         from '@angular/core';
import { Observable }         from 'rxjs';
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
        var response = this.http.get<Group>(this.url + "/" + id);
        return this.parseToGroup(response);
    }

    getGroups(): Array<Group> {
        var response = this.http.get<Array<Group>>(this.url);
        return this.parseToListGroups(response);
    }

    saveGroup(group: Group) {
        var response = this.http.post<Group>(this.url, group);
        return this.parseToGroup(response);
    }

    deleteGroup(id: number) {
        var response;
        this.http.delete(this.url + "/" + id).subscribe(item => {
            response = item;
        }, error => {
            console.error(error);
        });
        return response;
    }

    private parseToGroup(observable: Observable<Group>): Group {
        var group = new Group();
        observable.subscribe(item => {
            group.id = item.id;
            group.cource = item.cource;
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

    private parseToListGroups(observable: Observable<Array<Group>>): Array<Group> {
        var pupils = new Array<Group>();
        observable.subscribe(response => {
            response.map(item => {
                var group = new Group();
                group.id = item.id;
                group.cource = item.cource;
                group.faculty = item.faculty;
                group.groupNo = item.groupNo;
                if (item.pupils) {
                    group.pupils = item.pupils;
                }
                pupils.push(group);
            })
        }, error => {
            console.error(error);
        });
        return pupils;
    }
}