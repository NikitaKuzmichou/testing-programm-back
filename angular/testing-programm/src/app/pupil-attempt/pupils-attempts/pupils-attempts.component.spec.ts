import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PupilsAttemptsComponent } from './pupils-attempts.component';

describe('PupilsAttemptsComponent', () => {
  let component: PupilsAttemptsComponent;
  let fixture: ComponentFixture<PupilsAttemptsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PupilsAttemptsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PupilsAttemptsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
