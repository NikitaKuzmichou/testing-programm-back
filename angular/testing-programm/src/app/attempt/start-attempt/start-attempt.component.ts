import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';

import { Attempt } from '../attempt';
import { AttemptService } from '../attempt.service';
import { Group } from '../../group/group';
import { Task } from '../../task/task';
import { TaskService } from '../../task/task.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';
import { Subject } from '../../subject/subject';
import { TaskType } from '../../taskType/taskType';
import { SubjectService } from '../../subject/subject.service';
import { TaskTypeService } from '../../taskType/taskType.service';

@Component({
  selector: 'app-start-attemt',
  templateUrl: './start-attempt.component.html',
  styleUrls: ['./start-attempt.component.css']
})
export class StartAttemptComponent implements OnInit {
  attempt: Attempt;
  subjects: Subject[];
  taskTypes: TaskType[];
  tasks: Task[];
  selectedTask: Task;
  selectedGroup: Group;

  constructor(private router: Router,
              private subjectService: SubjectService,
              private attemptService: AttemptService,
              private taskTypeService: TaskTypeService,
              private taskService: TaskService) {
    this.subjectService.setUrl(ServerRequestUrls.SUBJECT);
    this.attemptService.setUrl(ServerRequestUrls.ATTEMPT);
    this.taskTypeService.setUrl(ServerRequestUrls.TASK_TYPE);
    this.taskService.setUrl(ServerRequestUrls.TASK);
  }

  ngOnInit() {
    this.attempt = new Attempt();
    this.selectedTask = new Task();
    this.selectedTask.type = new TaskType();
    this.selectedTask.subject = new Subject();
    this.subjects = this.getSubjectsRequest();
  }

  /**TODO если выбрать окончатель задание и поменять некоторый срединный этап - ничего не сбросится. Нужно починить*/
  selectSubject() {
    this.taskTypes = this.getTaskTypesRequest();
  }

  isSubjectSelected() {
    return this.selectedTask.subject.id === undefined;
  }

  selectTaskType() {
    this.tasks = this.getTaskRequest();
  }

  isTaskTypeSelected() {
    return this.selectedTask.type.id === undefined;
  }

  selectGroup(group) {
    this.selectedGroup = group;
  }

  isPossibleToStart() {
    const taskDefined = this.attempt.task !== undefined;
    let groupDefined = false;
    if (this.selectedGroup !== undefined) {
      groupDefined = this.selectedGroup.id !== undefined;
    }
    const attemptTimeDefined = this.attempt.start !== undefined;
    return taskDefined && groupDefined && attemptTimeDefined;
  }

  setAttemptTime(minutes) {
    if (!minutes) {
      this.attempt.start = undefined;
      this.attempt.end = undefined;
      return;
    }
    this.attempt.start = Date.now();
    this.attempt.end = this.attempt.start + minutes*60000;
  }

  onSubmit() {
    this.saveAttempt(this.attempt, this.selectedGroup);
    this.router.navigateByUrl('attempts');
  }

  private getSubjectsRequest() {
    return this.subjectService.getSubjects();
  }

  private getTaskTypesRequest() {
    return this.taskTypeService.getTaskTypesBySubject(this.selectedTask.subject.id);
  }

  private getTaskRequest() {
    return this.taskService.getTasksBySubjectAndTaskType(this.selectedTask.subject.id, this.selectedTask.type.id);
  }

  private saveAttempt(attempt: Attempt, selectedGroup: Group) {
    return this.attemptService.postAttempt(attempt, selectedGroup.id);
  }
}
