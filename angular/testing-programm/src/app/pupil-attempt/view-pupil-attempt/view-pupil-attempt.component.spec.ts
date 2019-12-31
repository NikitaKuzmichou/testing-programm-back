import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPupilAttemptComponent } from './view-pupil-attempt.component';

describe('ViewPupilAttemptComponent', () => {
  let component: ViewPupilAttemptComponent;
  let fixture: ComponentFixture<ViewPupilAttemptComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewPupilAttemptComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPupilAttemptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
