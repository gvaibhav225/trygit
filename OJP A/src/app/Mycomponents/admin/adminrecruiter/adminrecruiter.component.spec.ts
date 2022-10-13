import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminrecruiterComponent } from './adminrecruiter.component';

describe('AdminrecruiterComponent', () => {
  let component: AdminrecruiterComponent;
  let fixture: ComponentFixture<AdminrecruiterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminrecruiterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminrecruiterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
