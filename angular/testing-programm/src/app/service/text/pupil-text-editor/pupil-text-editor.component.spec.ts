import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PupilTextEditorComponent } from './pupil-text-editor.component';

describe('PupilTextEditorComponent', () => {
  let component: PupilTextEditorComponent;
  let fixture: ComponentFixture<PupilTextEditorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PupilTextEditorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PupilTextEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
