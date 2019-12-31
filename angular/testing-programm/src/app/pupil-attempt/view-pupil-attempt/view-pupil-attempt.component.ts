import { Component, OnInit } from '@angular/core';
import { ActivatedRoute }    from '@angular/router';

import { PupilAttempt } from '../pupilAttempt';
import { PupilAttemptService } from '../pupilAttempt.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';
import { Mistake } from '../../mistake/mistake';

@Component({
  selector: 'app-view-pupil-attempt',
  templateUrl: './view-pupil-attempt.component.html',
  styleUrls: ['./view-pupil-attempt.component.css']
})
export class ViewPupilAttemptComponent implements OnInit {
  pupilAttempt: PupilAttempt;
  pupilId: string;
  attemptId: string;
  mistakes: Mistake[];

  constructor(private pupilAttemptService: PupilAttemptService,
              private route: ActivatedRoute,) {
                console.log("hey");
    this.pupilId = this.route.snapshot.paramMap.get("pupilId");
    this.attemptId = this.route.snapshot.paramMap.get("attemptId");
    this.pupilAttemptService.setUrl(ServerRequestUrls.PUPIL_ATTEMPT);
    this.pupilAttempt = this.requestPupilAttempt();
    this.mistakes = this.pupilAttempt.mistakes;
   }

  ngOnInit() {
  }

  hasErrors() {
    return this.mistakes.length != 0;
  }

  getTextWithoutMistakes(mistake) {
    if (mistake == 0) {
      return this.pupilAttempt.text.substring(0, this.mistakes[mistake].colNo);
    }
    return this.pupilAttempt.text.substring(this.mistakes[mistake - 1].colNo + 1, this.mistakes[mistake].colNo);
  }

  getMistakeSymbol(mistake) {
    return this.pupilAttempt.text[mistake];
  }

  private requestPupilAttempt() {
    return this.pupilAttemptService.getPupilAttempt(+this.pupilId, +this.attemptId);
  }
}
