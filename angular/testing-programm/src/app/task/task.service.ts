import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Task } from './task';

@Injectable({
    providedIn: 'root'
}) export class TaskService {
    private url: string;
    constructor(private http: HttpClient) {}

    setUrl(url: string) {
        this.url = url;
    }

    getTask(id: number): Task {
        const response = this.http.get<Task>(this.url + '/' + id);
        return this.parseToTask(response);
    }

    getTasks(): Array<Task> {
        const response = this.http.get<Array<Task>>(this.url);
        return this.parseToListTasks(response);
    }

    getTasksBySubjectAndTaskType(subjectId: number, taskTypeId: number): Array<Task> {
        const response = this.http.get<Array<Task>>(this.url + '/' + subjectId + '/' + taskTypeId);
        return this.parseToListTasks(response);
    }

    updateTask(task: Task) {
        const response = this.http.put<Task>(this.url, task);
        return this.parseToTask(response);
    }

    saveTask(task: Task) {
        const response = this.http.post<Task>(this.url, task);
        return this.parseToTask(response);
    }

    deleteTask(id: number) {
        let response;
        this.http.delete(this.url + '/' + id).subscribe(item => {
            response = item;
        }, error => {
            console.error(error);
        });
        return response;
    }

    private parseToTask(observable: Observable<Task>): Task {
        const task = new Task();
        observable.subscribe(item => {
            task.id = item.id;
            task.name = item.name;
            task.subject = item.subject;
            task.taskText = item.taskText;
            task.type = item.type;
            task.uploader = item.uploader;
            task.description = item.description;
        }, error => {
            console.error(error);
        });
        return task;
    }

    private parseToListTasks(observable: Observable<Array<Task>>): Array<Task> {
        const tasks = new Array<Task>();
        observable.subscribe(response => {
            response.map(item => {
                const task = new Task();
                task.id = item.id;
                task.name = item.name;
                task.subject = item.subject;
                task.taskText = item.taskText;
                task.type = item.type;
                task.uploader = item.uploader;
                task.description = item.description;
                tasks.push(task);
            });
        }, error => {
            console.error(error);
        });
        return tasks;
    }
}
