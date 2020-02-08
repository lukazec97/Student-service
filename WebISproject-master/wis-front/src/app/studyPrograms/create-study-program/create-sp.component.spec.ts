import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSpComponent } from './create-sp.component';

describe('CreateSpComponent', () => {
  let component: CreateSpComponent;
  let fixture: ComponentFixture<CreateSpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateSpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateSpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
