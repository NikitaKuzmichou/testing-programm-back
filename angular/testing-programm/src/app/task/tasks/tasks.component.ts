import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Task } from '../task';
import { TaskService } from '../task.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {
  tasks: Array<Task>;

  constructor(private taskService: TaskService,
              private router: Router) {
    this.taskService.setUrl(ServerRequestUrls.TASK);
  }

  ngOnInit(): void {
    this.tasks = this.getTasksRequest();
  }

  update() {
    this.tasks = this.getTasksRequest();
  }

  private getTasksRequest() {
    return this.taskService.getTasks();
  }
}
