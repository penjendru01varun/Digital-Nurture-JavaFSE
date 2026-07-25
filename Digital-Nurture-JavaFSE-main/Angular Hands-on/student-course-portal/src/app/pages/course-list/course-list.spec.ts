import { ComponentFixture, TestBed } from '@angular/core/testing';
import { provideHttpClient } from '@angular/common/http';
import { provideRouter } from '@angular/router';
import { provideMockStore, MockStore } from '@ngrx/store/testing';
import { CourseListComponent } from './course-list';

describe('CourseListComponent', () => {
  let fixture: ComponentFixture<CourseListComponent>;
  let store: MockStore;
  const course = { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' as const };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseListComponent],
      providers: [
        provideHttpClient(),
        provideRouter([]),
        provideMockStore({ initialState: { course: { courses: [course], loading: false, error: null }, enrollment: { enrolledCourseIds: [] } } })
      ]
    }).compileComponents();
    store = TestBed.inject(MockStore);
    fixture = TestBed.createComponent(CourseListComponent);
  });

  it('renders course cards from the NgRx store', () => {
    fixture.detectChanges();
    expect(fixture.nativeElement.querySelectorAll('app-course-card').length).toBe(1);
  });

  it('shows the loading indicator for a loading store state', () => {
    store.setState({ course: { courses: [], loading: true, error: null }, enrollment: { enrolledCourseIds: [] } });
    fixture.detectChanges();
    expect(fixture.nativeElement.textContent).toContain('Loading courses...');
  });
});
