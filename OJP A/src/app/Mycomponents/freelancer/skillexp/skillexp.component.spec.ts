import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SkillexpComponent } from './skillexp.component';

describe('SkillexpComponent', () => {
  let component: SkillexpComponent;
  let fixture: ComponentFixture<SkillexpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SkillexpComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SkillexpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
