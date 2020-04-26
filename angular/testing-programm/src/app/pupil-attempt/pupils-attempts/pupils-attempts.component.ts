import { Component, OnInit } from '@angular/core';

import { PupilAttempt } from '../pupilAttempt';
import { PupilAttemptService } from '../pupilAttempt.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';

@Component({
  selector: 'app-pupils-attempts',
  templateUrl: './pupils-attempts.component.html',
  styleUrls: ['./pupils-attempts.component.css']
})
export class PupilsAttemptsComponent implements OnInit {

  pupilAttempts: PupilAttempt[];

  constructor(private pupilAttemptService: PupilAttemptService) {
    this.pupilAttemptService.setUrl(ServerRequestUrls.PUPIL_ATTEMPT);
  }

  ngOnInit(): void {
    this.pupilAttempts = this.getPupilsAttemptsRequest();
  }

  update() {
    this.pupilAttempts = this.getPupilsAttemptsRequest();
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

  private getPupilsAttemptsRequest() {
    return this.pupilAttemptService.getPupilAttempts();
  }
}
