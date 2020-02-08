import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateYearOfStudyComponent } from './create-year-of-study.component';

describe('CreateYearOfStudyComponent', () => {
  let component: CreateYearOfStudyComponent;
  let fixture: ComponentFixture<CreateYearOfStudyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateYearOfStudyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateYearOfStudyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
