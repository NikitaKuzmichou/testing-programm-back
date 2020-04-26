import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Attempt } from '../attempt';
import { AttemptService } from '../attempt.service';
import { ServerRequestUrls } from '../../ServerRequestUrls';

@Component({
  selector: 'app-view-attempt',
  templateUrl: './view-attempt.component.html',
  styleUrls: ['./view-attempt.component.css']
})
export class ViewAttemptComponent implements OnInit {
  attempt: Attempt;

  constructor(private attemptService: AttemptService,
              private route: ActivatedRoute) {
    this.attemptService.setUrl(ServerRequestUrls.ATTEMPT);
  }

  ngOnInit() {
    this.attempt = this.getAttempt();
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
    return Date.now() - (new Date(attempt.end)).getTime() > 0;
  }

  update() {
    this.attempt = this.getAttempt();
  }

  private getAttempt() {
    return this.attemptService.getAttempt(+this.route.snapshot.paramMap.get('attemptId'));
  }
}
