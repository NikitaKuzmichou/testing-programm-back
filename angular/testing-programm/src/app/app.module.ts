import { BrowserModule }              from '@angular/platform-browser';
import { NgModule }                   from '@angular/core';
import { HttpClientModule }           from '@angular/common/http';
import { FormsModule }                from '@angular/forms';
import { ReactiveFormsModule }        from '@angular/forms';
import { AlertModule } from 'ngx-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { StartAttemtComponent } from './attempt/start-attempt/start-attempt.component';
import { AttemptsComponent } from './attempt/attempts/attempts.component';

import { PupilAttemptComponent } from './pupil-attempt/pupil-attempt/pupil-attempt.component';
import { ViewPupilAttemptComponent } from './pupil-attempt/view-pupil-attempt/view-pupil-attempt.component';

@NgModule({
  declarations: [
    AppComponent,
    StartAttemtComponent,
    AttemptsComponent,
    PupilAttemptComponent,
    ViewPupilAttemptComponent
  ],
  imports: [
    AlertModule.forRoot(),
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
