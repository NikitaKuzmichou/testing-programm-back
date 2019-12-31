import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';

import { AttemptsComponent } from './attempt/attempts/attempts.component';
import { StartAttemtComponent } from './attempt/start-attempt/start-attempt.component'

import { ViewPupilAttemptComponent } from './pupil-attempt/view-pupil-attempt/view-pupil-attempt.component';
import { PupilAttemptComponent } from './pupil-attempt/pupil-attempt/pupil-attempt.component';

const routes: Routes = [
    { path: 'index', component: AppComponent },

    { path: 'attempts', component: AttemptsComponent },
    { path: 'attempt/start', component: StartAttemtComponent },

    { path: 'pupil-attempts/:pupilId/:attemptId', component: ViewPupilAttemptComponent },
    { path: 'pupil-attempt/:pupilId/:attemptId', component: PupilAttemptComponent }
    //{ path: '', component:  },
];

@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
  })
  export class AppRoutingModule { }
