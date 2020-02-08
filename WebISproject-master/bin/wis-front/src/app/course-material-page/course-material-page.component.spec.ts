import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseMaterialPageComponent } from './course-material-page.component';

describe('CourseMaterialPageComponent', () => {
  let component: CourseMaterialPageComponent;
  let fixture: ComponentFixture<CourseMaterialPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseMaterialPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseMaterialPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
