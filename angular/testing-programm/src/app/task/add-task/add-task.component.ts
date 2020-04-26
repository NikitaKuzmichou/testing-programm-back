import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

import { TaskService } from '../task.service';
import { Task } from '../task';
import { TaskType } from '../../taskType/taskType';
import { TaskTypeService } from '../../taskType/taskType.service';
import { Subject } from '../../subject/subject';
import { SubjectService } from '../../subject/subject.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';
import { Teacher } from '../../teacher/teacher';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {
  task: Task;
  subjects: Subject[];
  taskTypes: TaskType[];

  constructor(private router: Router,
              private taskService: TaskService,
              private taskTypeService: TaskTypeService,
              private subjectService: SubjectService) {
    this.taskService.setUrl(ServerRequestUrls.TASK);
    this.taskTypeService.setUrl(ServerRequestUrls.TASK_TYPE);
    this.subjectService.setUrl(ServerRequestUrls.SUBJECT);
  }

  /**TODO*/
  setUploaderId(uploaderId: number) {
    this.task.uploader = new Teacher();
    this.task.uploader.id = uploaderId;
  }

  ngOnInit(): void {
    this.task = new Task();
    this.subjects = this.getSubjectsRequest();
    this.taskTypes = this.getTaskTypesRequest();
  }

  setTaskName(name) {
    this.task.name = name;
  }

  updateDescription($event) {
    this.task.description = $event;
  }

  updateTaskText($event) {
    this.task.taskText = $event;
  }

  isCanBeSaved() {
    return this.task.hasSubject()
           && this.task.hasType()
           && this.task.hasName()
           && this.task.hasText();
  }

  onSubmit() {
    this.saveTaskRequest(this.task);
    this.router.navigateByUrl('tasks');
  }

  private getSubjectsRequest() {
    return this.subjectService.getSubjects();
  }

  private getTaskTypesRequest() {
    return this.taskTypeService.getTaskTypes();
  }

  private saveTaskRequest(task: Task) {
    return this.taskService.saveTask(task);
  }
}
