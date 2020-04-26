import { Component, OnInit } from '@angular/core';
import { Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { Group } from '../../group/group';
import { GroupService } from '../../group/group.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';

@Component({
  selector: 'app-select-group',
  templateUrl: './select-group.component.html',
  styleUrls: ['./select-group.component.css']
})
export class SelectGroupComponent implements OnInit {
  faculties: string[];
  courses: number[];
  groups: Group[];
  selectedGroup: Group;
  @Output() result = new EventEmitter<Group>();

  constructor(private groupsService: GroupService) {
    this.groupsService.setUrl(ServerRequestUrls.GROUPS);
  }

  ngOnInit(): void {
    this.selectedGroup = new Group();
    this.faculties = this.getFacultiesRequest();
  }

  selectFaculty() {
    this.courses = this.getCoursesRequest(this.selectedGroup.faculty);
  }

  isFacultySelected() {
    return this.selectedGroup.faculty === undefined;
  }

  selectCourse() {
    this.groups = this.getGroups(this.selectedGroup.faculty, this.selectedGroup.course);
  }

  isCourseSelected() {
    return this.selectedGroup.course === undefined;
  }

  selectGroup() {
    this.result.emit(this.selectedGroup);
  }

  private getFacultiesRequest() {
    return this.groupsService.getFaculties('faculties');
  }

  private getCoursesRequest(faculty: string) {
    return this.groupsService.getCourses(faculty, 'courses');
  }

  private getGroups(faculty: string, course: number) {
    return this.groupsService.getGroupsByFacultyAndCourse(faculty, course);
  }
}
