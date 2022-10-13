import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookmarkfreelancerComponent } from './bookmarkfreelancer.component';

describe('BookmarkfreelancerComponent', () => {
  let component: BookmarkfreelancerComponent;
  let fixture: ComponentFixture<BookmarkfreelancerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookmarkfreelancerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BookmarkfreelancerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
