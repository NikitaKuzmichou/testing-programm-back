import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router/router';

import { Attempt } from '../attempt';
import { AttemptService } from '../attempt.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';

@Component({
  selector: 'app-attempts',
  templateUrl: './attempts.component.html',
  styleUrls: ['./attempts.component.css']
})
export class AttemptsComponent implements OnInit {
  title = "Написанные работы";
  attempts: Attempt[];

  constructor(private attemptService: AttemptService) {
    console.log("hey");
    this.attemptService.setUrl(ServerRequestUrls.ATTEMPT);
    this.attempts = this.doRequest();
  }

  ngOnInit() {
  }

  isTimeOut(attempt: Attempt) {
    return attempt.end.getTime() - Date.now() > 0;
  }

  private doRequest() {
    return this.attemptService.getAttempts();
  }

}
