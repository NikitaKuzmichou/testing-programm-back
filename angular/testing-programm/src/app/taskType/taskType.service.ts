import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TaskType } from './taskType';

@Injectable({
    providedIn: 'root'
}) export class TaskTypeService {
    private url: string;
    constructor(private http: HttpClient) {}

    setUrl(url: string) {
        this.url = url;
    }

    getTaskType(id: number): TaskType {
        const response = this.http.get<TaskType>(this.url + "/" + id);
        return this.parseToTaskType(response);
    }

    getTaskTypes(): Array<TaskType> {
        const response = this.http.get<Array<TaskType>>(this.url);
        return this.parseToListTaskTypes(response);
    }

    getTaskTypesBySubject(subjectId: number): Array<TaskType> {
        const response = this.http.get<Array<TaskType>>(this.url + "/subject/" + subjectId);
        return this.parseToListTaskTypes(response);
    }

    saveTaskType(task: TaskType) {
        const response = this.http.post<TaskType>(this.url, task);
        return this.parseToTaskType(response);
    }

    deleteTaskType(id: number) {
        let response;
        this.http.delete(this.url + "/" + id).subscribe(item => {
            response = item;
        }, error => {
            console.error(error);
        });
        return response;
    }

    private parseToTaskType(observable: Observable<TaskType>): TaskType {
        const task = new TaskType();
        observable.subscribe(item => {
            task.id = item.id;
            task.name = item.name;
        }, error => {
            console.error(error);
        });
        return task;
    }

    private parseToListTaskTypes(observable: Observable<Array<TaskType>>): Array<TaskType> {
        const tasks = new Array<TaskType>();
        observable.subscribe(response => {
            response.map(item => {
                const task = new TaskType();
                task.id = item.id;
                task.name = item.name;
                tasks.push(task);
            })
        }, error => {
            console.error(error);
        });
        return tasks;
    }
}
