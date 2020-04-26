import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RoleService } from '../../role/role.service';
import { Pupil } from '../pupil';
import { PupilService } from '../pupil.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';

@Component({
  selector: 'app-add-pupil',
  templateUrl: './add-pupil.component.html',
  styleUrls: ['./add-pupil.component.css']
})
export class AddPupilComponent implements OnInit {
  pupil: Pupil;

  constructor(private router: Router,
              private pupilService: PupilService,
              private roleService: RoleService) {
    this.pupilService.setUrl(ServerRequestUrls.PUPILS);
    this.roleService.setUrl(ServerRequestUrls.ROLE);
  }

  ngOnInit(): void {
    this.pupil = new Pupil();
    this.pupil.role = this.getPupilRoleRequest();
  }

  setPupilName(name) {
    this.pupil.name = name;
  }

  setPupilSurname(surname) {
    this.pupil.surname = surname;
  }

  setPupilPatronymic(patronymic) {
    this.pupil.patronymic = patronymic;
  }

  setPupilLogin(login) {
    this.pupil.login = login;
  }

  setPupilPassword(password) {
    this.pupil.password = password;
  }

  setPupilGroup($event) {
    this.pupil.group = $event;
  }

  isCanBeSaved() {
    return this.pupil.hasName()
           && this.pupil.hasSurname()
           && this.pupil.hasLogin()
           && this.pupil.hasPassword()
           && this.pupil.hasGroup();
  }

  onSave() {
    this.savePupilRequest(this.pupil);
    this.router.navigateByUrl('pupils');
  }

  private savePupilRequest(pupil: Pupil) {
    this.pupilService.savePupil(pupil);
  }

  private getPupilRoleRequest() {
    return this.roleService.getRoleByName("PUPIL");
  }
}
