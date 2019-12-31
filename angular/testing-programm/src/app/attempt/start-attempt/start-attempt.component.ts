import { Component, OnInit } from '@angular/core';
import { Router }  from '@angular/router';

import { Attempt } from '../attempt';
import { AttemptService } from '../attempt.service';
import { Task } from '../../task/task';
import { TaskService } from '../../task/task.service';
import { Group }  from '../../group/group';
import { GroupService } from '../../group/group.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';
import { Subject } from '../../subject/subject';
import { SubjectService } from '../../subject/subject.service';

@Component({
  selector: 'app-start-attemt',
  templateUrl: './start-attempt.component.html',
  styleUrls: ['./start-attempt.component.css']
})
export class StartAttemtComponent implements OnInit {
  title = "Начать новое задание";
  groups: Group[];
  tasks: Task[];
  subjects: Subject[];
  sortedGroups = new Array<Group>();
  sortedTasks= new Array<Task>();
  attempt = new Attempt();

  constructor(private groupService: GroupService,
              private taskService: TaskService,
              private subjectService: SubjectService,
              private attemptService: AttemptService,
              private router: Router) {
                console.log("hey");
    this.subjectService.setUrl(ServerRequestUrls.SUBJECT);
    this.groupService.setUrl(ServerRequestUrls.GROUPS);
    this.taskService.setUrl(ServerRequestUrls.TASK);
    this.attemptService.setUrl(ServerRequestUrls.ATTEMPT);
    this.subjects = this.getSubjectsRequest();
    this.groups = this.getGroupsRequest();
    this.tasks = this.getTasksRequest();
  }

  ngOnInit() {
  }

  getFaculties() {
    var faculties = new Array<string>();
    this.groups.forEach(group => {
      if (faculties.indexOf(group.faculty) == -1) {
        faculties.push(group.faculty);
      }
    });
    return faculties;
  }

  getFoundGroups() {
    return this.sortedGroups.length == 0 ? null : this.sortedGroups;
  }

  getFoudTasks() {
    return this.sortedTasks.length == 0 ? null : this.sortedTasks;
  }

  findGroupsByFaculty(faculty) {
    if (this.sortedGroups.length != 0 && this.sortedGroups[0].faculty == faculty) {
      return this.sortedGroups;
    }
    this.sortedGroups = new Array<Group>();
    this.groups.forEach(group => {
      if (group.faculty == faculty) {
        this.sortedGroups.push(group);
      }
    });
  }

  /**TODO SORT BY SUBJECT AND BU TYPE */
  findTasksBySubject(subject) {
    if (this.sortedTasks.length != 0 && this.sortedTasks[0].subject == subject) {
      return this.sortedTasks;
    }
    this.sortedTasks = new Array<Task>();
    this.tasks.forEach(task => {
      if (task.subject == subject) {
        this.sortedTasks.push(task);
      }
    });
  }

  setAttemptTime(minutes) {
    let start = new Date();
    let end = new Date(start.getTime + minutes);
    this.attempt.start = start;
    this.attempt.end = end;
  }

  onSubmut() {
    this.saveAttempt();
    this.router.navigateByUrl("attempts");
  }

  private getSubjectsRequest() {
    return this.subjectService.getSubjects();
  }

  private getGroupsRequest() {
    return this.groupService.getGroups();
  }

  private getTasksRequest() {
    return this.taskService.getTasks();
  }

  private saveAttempt() {
    return this.attemptService.postAttempt(this.attempt);
  }

}
