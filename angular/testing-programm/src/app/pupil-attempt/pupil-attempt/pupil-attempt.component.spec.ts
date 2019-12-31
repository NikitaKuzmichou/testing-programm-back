import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PupilAttemptComponent } from './pupil-attempt.component';

describe('PupilAttemptComponent', () => {
  let component: PupilAttemptComponent;
  let fixture: ComponentFixture<PupilAttemptComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PupilAttemptComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PupilAttemptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
