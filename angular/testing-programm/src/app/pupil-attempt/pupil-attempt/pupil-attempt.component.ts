import { Component, OnInit } from '@angular/core';
import { ActivatedRoute }    from '@angular/router';
import { Router }  from '@angular/router';

import { PupilAttempt } from '../pupilAttempt';
import { PupilAttemptService } from '../pupilAttempt.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';

@Component({
  selector: 'app-pupil-attempt',
  templateUrl: './pupil-attempt.component.html',
  styleUrls: ['./pupil-attempt.component.css']
})
export class PupilAttemptComponent implements OnInit {
  pupilAttempt: PupilAttempt;
  pupilId: string;
  attemptId: string;

  constructor(private pupilAttemptService: PupilAttemptService,
              private route: ActivatedRoute,
              private router: Router) {
                console.log("hey");
    this.pupilId = this.route.snapshot.paramMap.get("pupilId");
    this.attemptId = this.route.snapshot.paramMap.get("attemptId");
    this.pupilAttemptService.setUrl(ServerRequestUrls.PUPIL_ATTEMPT);
    this.pupilAttempt = this.requestPupilAttempt();
  }

  ngOnInit() {
  }

  onSubmit() {
    this.savePupilAttempt();
    this.router.navigateByUrl("pupil-attempt/" + this.pupilId + "/" + this.attemptId);
  }

  updatePupilText(text) {
    this.pupilAttempt.text = text;
  }

  private requestPupilAttempt() {
    return this.pupilAttemptService.getPupilAttempt(+this.pupilId, +this.attemptId);
  }

  private savePupilAttempt() {
    return this.pupilAttemptService.savePupilAttempt(this.pupilAttempt);
  }

}
