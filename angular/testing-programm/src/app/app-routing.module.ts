import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CommonModule} from '@angular/common';

import { AppComponent } from './app.component';
import { LinksComponent } from './utility/links/links.component';

import { AttemptsComponent } from './attempt/attempts/attempts.component';
import { StartAttemptComponent } from './attempt/start-attempt/start-attempt.component';
import { ViewAttemptComponent } from './attempt/view-attempt/view-attempt.component';

import { TasksComponent } from './task/tasks/tasks.component';
import { ViewTaskComponent } from './task/view-task/view-task.component';
import { AddTaskComponent } from './task/add-task/add-task.component';
import { EditTaskComponent } from './task/edit-task/edit-task.component';
import { DeleteTaskComponent } from './task/delete-task/delete-task.component';

import { PupilsComponent } from './pupil/pupils/pupils.component';
import { ViewPupilComponent } from './pupil/view-pupil/view-pupil.component';
import { AddPupilComponent } from './pupil/add-pupil/add-pupil.component';
import { EditPupilComponent } from './pupil/edit-pupil/edit-pupil.component';

import { ViewPupilAttemptComponent } from './pupil-attempt/view-pupil-attempt/view-pupil-attempt.component';
import { PupilsAttemptsComponent } from './pupil-attempt/pupils-attempts/pupils-attempts.component';
import { PupilAttemptComponent } from './pupil-attempt/pupil-attempt/pupil-attempt.component';

const routes: Routes = [
    { path: 'index', component: AppComponent },
    { path: 'links', component: LinksComponent },

    { path: 'attempts', component: AttemptsComponent },
    { path: 'attempts-start', component: StartAttemptComponent },
    { path: 'attempts/:attemptId', component: ViewAttemptComponent },

    { path: 'tasks', component: TasksComponent },
    { path: 'tasks/:taskId', component: ViewTaskComponent },
    { path: 'tasks-add', component: AddTaskComponent },
    { path: 'tasks-edit/:taskId', component: EditTaskComponent },
    { path: 'tasks-delete/:taskId', component: DeleteTaskComponent },

    { path: 'pupils', component: PupilsComponent },
    { path: 'pupils/:pupilId', component: ViewPupilComponent },
    { path: 'pupils-add', component: AddPupilComponent },
    { path: 'pupils-edit/:pupilId', component: EditPupilComponent },

    { path: 'pupils-attempts', component: PupilsAttemptsComponent },
    { path: 'pupils-attempts-view/:pupilId/:attemptId', component: ViewPupilAttemptComponent },
    { path: 'pupils-attempts/:pupilId/:attemptId', component: PupilAttemptComponent },
    //{ path: 'pupils-attempt/:pupilId/:attemptId', component: PupilAttemptComponent }

    //{ path: '', component:  },
];

@NgModule({
    imports: [ RouterModule.forRoot(routes), CommonModule ],
    exports: [ RouterModule ]
  })
  export class AppRoutingModule { }
