import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import {Task} from '../task';
import {TaskService} from '../task.service';
import {ServerRequestUrls} from '../../ServerRequestUrls';

@Component({
  selector: 'app-view-task',
  templateUrl: './view-task.component.html',
  styleUrls: ['./view-task.component.css']
})
export class ViewTaskComponent implements OnInit {
  task : Task;
  isChangeDescr = false;
  isChangeText = false;

  constructor(private route: ActivatedRoute,
              private taskService: TaskService) {
    this.taskService.setUrl(ServerRequestUrls.TASK);
  }

  ngOnInit(): void {
    this.task = this.getTaskRequest();
  }

  updateDescription($event) {
    this.task.description = $event;
  }

  updateText($event) {
    this.task.taskText = $event;
  }

  editTaskDescription() {
    this.isChangeDescr = !this.isChangeDescr;
  }

  saveTaskDescription() {
    this.isChangeDescr = !this.isChangeDescr;
    this.task = this.updateTaskRequest();
  }

  editTaskText() {
    this.isChangeText = !this.isChangeText;
  }

  saveTaskText() {
    this.isChangeText = !this.isChangeText;
    this.task = this.updateTaskRequest();
  }

  private getTaskRequest() {
    return this.taskService.getTask(+this.route.snapshot.paramMap.get('taskId'));
  }

  private updateTaskRequest() {
    return this.taskService.updateTask(this.task);
  }
}
