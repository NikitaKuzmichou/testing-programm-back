import { Component, OnInit } from '@angular/core';

import { Attempt } from '../attempt';
import { AttemptService } from '../attempt.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';

@Component({
  selector: 'app-attempts',
  templateUrl: './attempts.component.html',
  styleUrls: ['./attempts.component.css']
})
export class AttemptsComponent implements OnInit {
  attempts: Attempt[];

  constructor(private attemptService: AttemptService) {
    this.attemptService.setUrl(ServerRequestUrls.ATTEMPT);
  }

  ngOnInit() {
    this.attempts = this.getAttemptsRequest();
  }

  update() {
    this.attempts = this.getAttemptsRequest();
  }

  isTimeOut(attempt: Attempt) {
    return Date.now() - (new Date(attempt.end)).getTime() > 0;
  }

  private getAttemptsRequest() {
    return this.attemptService.getAttempts();
  }
}
