import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Task } from '../task';
import { TaskService } from '../task.service';
import { TaskType } from '../../taskType/taskType';
import { TaskTypeService } from '../../taskType/taskType.service';
import { Subject } from '../../subject/subject';
import { SubjectService } from '../../subject/subject.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';

@Component({
  selector: 'app-edit-task',
  templateUrl: './edit-task.component.html',
  styleUrls: ['./edit-task.component.css']
})
export class EditTaskComponent implements OnInit {
  task: Task;
  taskTypes: TaskType[];
  subjects: Subject[];

  constructor(private route: ActivatedRoute,
              private router: Router,
              private taskService: TaskService,
              private taskTypeService: TaskTypeService,
              private subjectService: SubjectService) {
    this.taskService.setUrl(ServerRequestUrls.TASK);
    this.taskTypeService.setUrl(ServerRequestUrls.TASK_TYPE);
    this.subjectService.setUrl(ServerRequestUrls.SUBJECT);
  }

  ngOnInit(): void {
    this.task = this.getTaskRequest();
    this.taskTypes = this.getTaskTypesRequest();
    this.taskTypes = this.taskTypes.splice(this.taskTypes.indexOf(this.task.type), 1);
    this.subjects = this.getSubjectsRequest();
    this.subjects = this.subjects.splice(this.subjects.indexOf(this.task.subject), 1);
  }

  setTaskName(name) {
    this.task.name = name;
  }

  subjectSelected() {
    this.taskTypes = this.getTaskTypesBySubjectRequest(this.task.subject.id);
  }

  setTaskDescription($event) {
    this.task.description = $event;
  }

  setTaskText($event) {
    this.task.taskText = $event;
  }

  isCanBeUpdated() {
    return this.task.hasName
           && this.task.hasSubject
           && this.task.hasText
           && this.task.hasType;
  }

  updateTask() {
    this.updateTaskRequest();
    this.router.navigateByUrl('tasks/' + this.task.id);
  }

  private getTaskRequest() {
    return this.taskService.getTask(+this.route.snapshot.paramMap.get('taskId'));
  }

  private getSubjectsRequest() {
    return this.subjectService.getSubjects();
  }

  private getTaskTypesRequest() {
    return this.taskTypeService.getTaskTypes();
  }

  private getTaskTypesBySubjectRequest(subjId: number) {
    return this.taskTypeService.getTaskTypesBySubject(subjId);
  }

  private updateTaskRequest() {
    return this.taskService.updateTask(this.task);
  }
}
