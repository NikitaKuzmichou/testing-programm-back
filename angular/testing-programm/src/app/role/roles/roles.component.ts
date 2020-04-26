import { Component, OnInit } from '@angular/core';
import { Role } from '../role';
import { RoleService } from '../role.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';

@Component({
  selector: 'app-roles',
  templateUrl: './roles.component.html',
  styleUrls: ['./roles.component.css']
})
export class RolesComponent implements OnInit {

  roles: Role[];

  constructor(private roleService: RoleService) { 
    this.roleService.setUrl(ServerRequestUrls.ROLE);
  }

  ngOnInit() {
    this.roles = this.getRolesRequest();
  }

  private getRolesRequest() {
    return this.roleService.getRoles();
  }
}
