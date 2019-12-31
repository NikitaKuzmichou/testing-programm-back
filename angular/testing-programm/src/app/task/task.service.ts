
import { HttpClient }         from '@angular/common/http';
import { Injectable }         from '@angular/core';
import { Observable }         from 'rxjs';
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
        var response = this.http.get<Task>(this.url + "/" + id);
        return this.parseToTask(response);
    }

    getTasks(): Array<Task> {
        var response = this.http.get<Array<Task>>(this.url);
        return this.parseToListTasks(response);
    }

    saveTask(task: Task) {
        var response = this.http.post<Task>(this.url, task);
        return this.parseToTask(response);
    }

    deleteTask(id: number) {
        var response;
        this.http.delete(this.url + "/" + id).subscribe(item => {
            response = item;
        }, error => {
            console.error(error);
        });
        return response;
    }

    private parseToTask(observable: Observable<Task>): Task {
        var task = new Task();
        observable.subscribe(item => {
            task.id = item.id;
            task.name = item.name;
            task.subject = item.subject;
            task.taskText = item.taskText;
            task.taskType = item.taskType;
            task.uploader = item.uploader;
            task.description = item.description;
        }, error => {
            console.error(error);
        });
        return task;
    }

    private parseToListTasks(observable: Observable<Array<Task>>): Array<Task> {
        var tasks = new Array<Task>();
        observable.subscribe(response => {
            response.map(item => {
                var task = new Task();
                task.id = item.id;
                task.name = item.name;
                task.subject = item.subject;
                task.taskText = item.taskText;
                task.taskType = item.taskType;
                task.uploader = item.uploader;
                task.description = item.description;
                tasks.push(task);
            })
        }, error => {
            console.error(error);
        });
        return tasks;
    }
}