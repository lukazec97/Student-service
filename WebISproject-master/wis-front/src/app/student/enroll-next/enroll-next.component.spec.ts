import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnrollNextComponent } from './enroll-next.component';

describe('EnrollNextComponent', () => {
  let component: EnrollNextComponent;
  let fixture: ComponentFixture<EnrollNextComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnrollNextComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnrollNextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
