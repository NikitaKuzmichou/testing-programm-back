import { Component, OnInit } from '@angular/core';

import { Pupil } from '../pupil';
import { PupilService } from '../pupil.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';

@Component({
  selector: 'app-pupils',
  templateUrl: './pupils.component.html',
  styleUrls: ['./pupils.component.css']
})
export class PupilsComponent implements OnInit {
  pupils: Pupil[];

  constructor(private pupilService: PupilService) {
    this.pupilService.setUrl(ServerRequestUrls.PUPILS);
  }

  ngOnInit() {
    this.pupils = this.getPupilsRequest();
  }

  update() {
    this.pupils = this.getPupilsRequest();
  }

  private getPupilsRequest() {
    return this.pupilService.getPupils();
  }

}
