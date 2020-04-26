import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

import { PupilAttempt } from '../pupilAttempt';
import { PupilAttemptService } from '../pupilAttempt.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';

@Component({
  selector: 'app-pupil-attempt',
  templateUrl: './pupil-attempt.component.html',
  styleUrls: ['./pupil-attempt.component.css']
})
/**TODO слишком много костылей*/
export class PupilAttemptComponent implements OnInit {
  pupilAttempt: PupilAttempt;
  lastUpdate: number;
  pupilId: string;
  attemptId: string;
  showTime = false;
  timeLeft: number;
  interval;

  constructor(private pupilAttemptService: PupilAttemptService,
              private route: ActivatedRoute,
              private router: Router) {
    this.pupilAttemptService.setUrl(ServerRequestUrls.PUPIL_ATTEMPT);
  }

  ngOnInit() {
    this.pupilId = this.route.snapshot.paramMap.get('pupilId');
    this.attemptId = this.route.snapshot.paramMap.get('attemptId');
    this.pupilAttempt = this.requestPupilAttempt();
    this.lastUpdate = 0;
  }

  showTimeLeft() {
    this.showTime = true;
    const timeDiff = this.pupilAttempt.attempt.end - Date.now();
    this.timeLeft = timeDiff > 0 ? Math.round(timeDiff / 60000) : 0;
    this.startTimer();
  }

  isTimeOut() {
    return 4 * this.pupilAttempt.attempt.end / 3 - Date.now() < 0;
  }

  onSubmit() {
    this.savePupilAttempt();
    this.router.navigateByUrl('pupils-attempts-view/' + this.pupilId + '/' + this.attemptId);
  }

  setPupilText($text) {
    this.pupilAttempt.text = $text;
    if (this.isUpdateTime()) {
      this.updatePupilText();
    }
  }

  updatePupilText() {
    this.updatePupilAttempt();
    this.lastUpdate = Date.now();
  }

  private startTimer() {
    this.interval = setInterval(() => {
      if (this.timeLeft > 0) {
        this.timeLeft --;
      } else {
        this.timeLeft = 0;
      }
    }, 60000);
  }

  private isUpdateTime() {
    return Date.now() - this.lastUpdate > 40;
  }

  private requestPupilAttempt() {
    return this.pupilAttemptService.getPupilAttempt(+this.pupilId, +this.attemptId);
  }

  private updatePupilAttempt() {
    return this.pupilAttemptService.updatePupilAttempt(this.pupilAttempt);
  }

  private savePupilAttempt() {
    return this.pupilAttemptService.savePupilAttempt(this.pupilAttempt);
  }
}
