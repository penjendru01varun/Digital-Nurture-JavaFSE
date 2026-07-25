import { ComponentFixture, TestBed } from '@angular/core/testing';
import { provideRouter } from '@angular/router';
import { provideMockStore, MockStore } from '@ngrx/store/testing';
import { CourseCardComponent } from './course-card';
describe('CourseCardComponent', () => {
  let component: CourseCardComponent;
  let fixture: ComponentFixture<CourseCardComponent>;
  let store: MockStore;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseCardComponent],
      providers: [provideRouter([]), provideMockStore({ initialState: { enrollment: { enrolledCourseIds: [] } } })]
    }).compileComponents();
    store = TestBed.inject(MockStore);
    fixture = TestBed.createComponent(CourseCardComponent);
    component = fixture.componentInstance;
    component.course = { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' };
    fixture.detectChanges();
  });

  it('creates the component', () => expect(component).toBeTruthy());
  it('renders the input course name', () => expect(fixture.nativeElement.querySelector('h3').textContent).toContain('Data Structures'));
  it('emits the course ID when Enroll is clicked', () => {
    spyOn(component.enrollRequested, 'emit');
    fixture.nativeElement.querySelectorAll('button')[2].click();
    expect(component.enrollRequested.emit).toHaveBeenCalledWith(1);
  });
  it('logs the previous and current course in ngOnChanges', () => {
    spyOn(console, 'log');
    component.ngOnChanges({ course: { previousValue: undefined, currentValue: component.course, firstChange: true, isFirstChange: () => true } });
    expect(console.log).toHaveBeenCalled();
  });
  it('shows Unenroll for an enrolled course', () => {
    store.setState({ enrollment: { enrolledCourseIds: [1] } });
    fixture.detectChanges();
    expect(fixture.nativeElement.querySelectorAll('button')[2].textContent).toContain('Unenroll');
  });
});
