import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminfreelancerComponent } from './adminfreelancer.component';

describe('AdminfreelancerComponent', () => {
  let component: AdminfreelancerComponent;
  let fixture: ComponentFixture<AdminfreelancerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminfreelancerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminfreelancerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
