import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Pupil } from '../pupil';
import { PupilService } from '../pupil.service';
import { Attempt } from '../../attempt/attempt';
import { PupilAttempt } from '../../pupil-attempt/pupilAttempt';
import { PupilAttemptService } from '../../pupil-attempt/pupilAttempt.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';

@Component({
  selector: 'app-view-pupil',
  templateUrl: './view-pupil.component.html',
  styleUrls: ['./view-pupil.component.css']
})
export class ViewPupilComponent implements OnInit {
  pupil: Pupil;
  pupilAttempts: PupilAttempt[];

  constructor(private route: ActivatedRoute,
              private pupilService: PupilService,
              private pupilAttemptService: PupilAttemptService) {
    this.pupilAttemptService.setUrl(ServerRequestUrls.PUPIL_ATTEMPT);
    this.pupilService.setUrl(ServerRequestUrls.PUPILS);
  }

  ngOnInit() {
    this.pupil = this.getPupilRequest(+this.route.snapshot.paramMap.get('pupilId'));
    this.pupilAttempts = this.getPupilAttemptRequest(+this.route.snapshot.paramMap.get('pupilId'));
  }

  update() {
    this.pupil = this.getPupilRequest(+this.route.snapshot.paramMap.get('pupilId'));
  }

  isGoodMark(mark: number) {
    return mark >= 7;
  }

  isNormalMark(mark: number) {
    return mark >= 5 && mark < 7;
  }

  isBadMark(mark: number) {
    return mark < 5;
  }

  isTimeOut(attempt: Attempt) {
    return Date.now() - attempt.end > 0;
  }

  private getPupilRequest(pupilId: number) {
    return this.pupilService.getPupil(pupilId);
  }

  private getPupilAttemptRequest(pupilId: number) {
    return this.pupilAttemptService.getPupilAttemptsById(pupilId);
  }

}
