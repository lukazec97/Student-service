import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetTeacherComponent } from './get-teacher.component';

describe('GetTeacherComponent', () => {
  let component: GetTeacherComponent;
  let fixture: ComponentFixture<GetTeacherComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetTeacherComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetTeacherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
