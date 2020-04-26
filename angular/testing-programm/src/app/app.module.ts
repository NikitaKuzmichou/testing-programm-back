import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { AlertModule } from 'ngx-bootstrap';
import { TextareaAutosizeModule } from 'ngx-textarea-autosize';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { StartAttemptComponent } from './attempt/start-attempt/start-attempt.component';
import { AttemptsComponent } from './attempt/attempts/attempts.component';
import { PupilAttemptComponent } from './pupil-attempt/pupil-attempt/pupil-attempt.component';
import { ViewPupilAttemptComponent } from './pupil-attempt/view-pupil-attempt/view-pupil-attempt.component';
import { TasksComponent } from './task/tasks/tasks.component';
import { PupilsComponent } from './pupil/pupils/pupils.component';
import { AddTaskComponent } from './task/add-task/add-task.component';
import { ViewTaskComponent } from './task/view-task/view-task.component';
import { EditTaskComponent } from './task/edit-task/edit-task.component';
import { DeleteTaskComponent } from './task/delete-task/delete-task.component';
import { TextEditorComponent } from './service/text/text-editor/text-editor.component';
import { AddPupilComponent } from './pupil/add-pupil/add-pupil.component';
import { EditPupilComponent } from './pupil/edit-pupil/edit-pupil.component';
import { GroupsComponent } from './group/groups/groups.component';
import { CreateGroupComponent } from './group/create-group/create-group.component';
import { EditGroupComponent } from './group/edit-group/edit-group.component';
import { DeleteGroupComponent } from './group/delete-group/delete-group.component';
import { CreateRoleComponent } from './role/create-role/create-role.component';
import { EditRoleComponent } from './role/edit-role/edit-role.component';
import { DeleteRoleComponent } from './role/delete-role/delete-role.component';
import { RulesComponent } from './rule/rules/rules.component';
import { ViewRuleComponent } from './rule/view-rule/view-rule.component';
import { AddRuleComponent } from './rule/add-rule/add-rule.component';
import { EditRuleComponent } from './rule/edit-rule/edit-rule.component';
import { DeleteRuleComponent } from './rule/delete-rule/delete-rule.component';
import { SubjectsComponent } from './subject/subjects/subjects.component';
import { AddSubjectComponent } from './subject/add-subject/add-subject.component';
import { EditSubjectComponent } from './subject/edit-subject/edit-subject.component';
import { DeleteSubjectComponent } from './subject/delete-subject/delete-subject.component';
import { ViewSubjectComponent } from './subject/view-subject/view-subject.component';
import { ViewTeacherComponent } from './teacher/view-teacher/view-teacher.component';
import { AddTeacherComponent } from './teacher/add-teacher/add-teacher.component';
import { EditTeacherComponent } from './teacher/edit-teacher/edit-teacher.component';
import { DeleteTeacherComponent } from './teacher/delete-teacher/delete-teacher.component';
import { ViewGroupComponent } from './group/view-group/view-group.component';
import { ViewRoleComponent } from './role/view-role/view-role.component';
import { SelectGroupComponent } from './group/select-group/select-group.component';
import { ViewPupilComponent } from './pupil/view-pupil/view-pupil.component';
import { PupilsAttemptsComponent } from './pupil-attempt/pupils-attempts/pupils-attempts.component';
import { ViewAttemptComponent } from './attempt/view-attempt/view-attempt.component';
import { PupilTextEditorComponent } from './service/text/pupil-text-editor/pupil-text-editor.component';
import { LinksComponent } from './utility/links/links.component';

@NgModule({
  declarations: [
    AppComponent,
    StartAttemptComponent,
    AttemptsComponent,
    PupilAttemptComponent,
    ViewPupilAttemptComponent,
    TasksComponent,
    AddTaskComponent,
    ViewTaskComponent,
    EditTaskComponent,
    DeleteTaskComponent,
    TextEditorComponent,
    AddPupilComponent,
    EditPupilComponent,
    GroupsComponent,
    CreateGroupComponent,
    EditGroupComponent,
    DeleteGroupComponent,
    CreateRoleComponent,
    EditRoleComponent,
    DeleteRoleComponent,
    RulesComponent,
    ViewRuleComponent,
    AddRuleComponent,
    EditRuleComponent,
    DeleteRuleComponent,
    SubjectsComponent,
    AddSubjectComponent,
    EditSubjectComponent,
    DeleteSubjectComponent,
    ViewSubjectComponent,
    ViewTeacherComponent,
    AddTeacherComponent,
    EditTeacherComponent,
    DeleteTeacherComponent,
    ViewGroupComponent,
    ViewRoleComponent,
    SelectGroupComponent,
    PupilsComponent,
    ViewPupilComponent,
    PupilsAttemptsComponent,
    ViewAttemptComponent,
    PupilTextEditorComponent,
    LinksComponent
  ],
  imports: [
    AlertModule.forRoot(),
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    TextareaAutosizeModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
