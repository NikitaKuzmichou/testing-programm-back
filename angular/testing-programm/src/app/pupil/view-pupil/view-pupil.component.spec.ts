import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPupilComponent } from './view-pupil.component';

describe('ViewPupilComponent', () => {
  let component: ViewPupilComponent;
  let fixture: ComponentFixture<ViewPupilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewPupilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPupilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
