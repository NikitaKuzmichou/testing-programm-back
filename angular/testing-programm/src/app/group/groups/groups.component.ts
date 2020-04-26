import { Component, OnInit } from '@angular/core';
import { Group } from '../group';
import { GroupService } from '../group.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';

@Component({
  selector: 'app-groups',
  templateUrl: './groups.component.html',
  styleUrls: ['./groups.component.css']
})
export class GroupsComponent implements OnInit {

  groups: Group[];

  constructor(private groupsService: GroupService) {
    this.groupsService.setUrl(ServerRequestUrls.GROUPS);
  }

  ngOnInit(): void {
    this.groups = this.getGroupsRequest();
  }

  private getGroupsRequest() {
    return this.groupsService.getGroups();
  }

}
