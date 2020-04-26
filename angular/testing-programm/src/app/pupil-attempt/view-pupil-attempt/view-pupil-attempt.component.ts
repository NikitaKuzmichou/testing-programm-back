import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { PupilAttempt } from '../pupilAttempt';
import { PupilAttemptService } from '../pupilAttempt.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';

@Component({
  selector: 'app-view-pupil-attempt',
  templateUrl: './view-pupil-attempt.component.html',
  styleUrls: ['./view-pupil-attempt.component.css']
})
export class ViewPupilAttemptComponent implements OnInit {
  pupilAttempt: PupilAttempt;

  constructor(private pupilAttemptService: PupilAttemptService,
              private route: ActivatedRoute) {
    this.pupilAttemptService.setUrl(ServerRequestUrls.PUPIL_ATTEMPT);
   }

  ngOnInit() {
    this.pupilAttempt = this.requestPupilAttempt();
    console.log(this.pupilAttempt);
  }

  update() {
    this.pupilAttempt = this.requestPupilAttempt();
  }

  getListWords() {
    if (this.pupilAttempt.text) {
      return this.pupilAttempt.text.split(' ');
    }
    return null;
  }

  setPupilMistakes($mistakes) {
    this.pupilAttempt.mistakes = $mistakes;
  }

  recheck() {
    this.pupilAttempt = this.requestRecheckPupilAttempt();
  }

  private requestPupilAttempt() {
    return this.pupilAttemptService.getPupilAttempt(+this.route.snapshot.paramMap.get('pupilId'),
                                                    +this.route.snapshot.paramMap.get('attemptId'));
  }

  private requestRecheckPupilAttempt() {
    return this.pupilAttemptService.recheckPupilAttempt(+this.route.snapshot.paramMap.get('pupilId'),
                                                        +this.route.snapshot.paramMap.get('attemptId'));
  }
}
