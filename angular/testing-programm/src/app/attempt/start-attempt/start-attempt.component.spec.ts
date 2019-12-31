import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StartAttemtComponent } from './start-attempt.component';

describe('StartAttemptComponent', () => {
  let component: StartAttemtComponent;
  let fixture: ComponentFixture<StartAttemtComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StartAttemtComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StartAttemtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
