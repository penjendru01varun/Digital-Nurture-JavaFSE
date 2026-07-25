import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';

import { CourseForm } from './course-form';
import { CourseService } from '../../services/course.service';

describe('CourseForm', () => {
  let component: CourseForm;
  let fixture: ComponentFixture<CourseForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseForm],
      providers: [{
        provide: CourseService,
        useValue: {
          getCourses: () => of([]),
          createCourse: () => of({}),
          updateCourse: () => of({}),
          deleteCourse: () => of(undefined)
        }
      }]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CourseForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('requires a valid course before it can be saved', () => {
    component.save();
    expect(component.form.invalid).toBeTrue();
  });
});
