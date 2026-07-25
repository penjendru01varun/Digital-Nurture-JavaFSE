import { Component, OnInit, OnDestroy, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CourseService } from '../../services/course.service';
import { Store } from '@ngrx/store';
import { Router } from '@angular/router';
import { selectEnrolledIds } from '../../store/enrollment/enrollment.selectors';
import { enrollInCourse, unenrollFromCourse } from '../../store/enrollment/enrollment.actions';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home implements OnInit, OnDestroy {

  portalName = 'Student Course Portal';

  isPortalActive = true;

  searchTerm = '';

  message = '';

  student = {
    name: 'Thanvika',
    email: 'thanvika@gmail.com',
    department: 'Computer Science',
    semester: 6,
    cgpa: 8.9,
    phone: '9876543210'
  };

  courses: Course[] = [];
  filteredCourses: Course[] = [];

  stats = [
    { title: 'Courses Available', value: 0 },
    { title: 'Enrolled', value: 0 },
    { title: 'GPA', value: 8.9 }
  ];

  private readonly store = inject(Store);
  readonly enrolledIds$ = this.store.select(selectEnrolledIds);
  constructor(private readonly courseService: CourseService, private readonly router: Router) {}

  ngOnInit() {
    this.courseService.getCourses().subscribe(courses => {
      this.courses = courses;
      this.filteredCourses = this.filterCourses(this.searchTerm);
      this.stats[0].value = courses.length;
    });
    this.store.select(selectEnrolledIds).subscribe(courseIds => this.stats[1].value = courseIds.length);
    console.log('HomeComponent initialised — courses loaded');
  }

  ngOnDestroy() {
    console.log('HomeComponent destroyed');
  }

  onEnrollClick(): void {
    this.router.navigate(['/enroll']);
  }

  toggleEnrollment(course: Course, enrolled: boolean): void {
    this.store.dispatch(enrolled ? unenrollFromCourse({ courseId: course.id }) : enrollInCourse({ courseId: course.id }));
    this.message = enrolled ? `${course.name} removed from your courses.` : `${course.name} enrolled successfully.`;
  }

  updateSearch() {
    this.filteredCourses = this.filterCourses(this.searchTerm);
  }

  private filterCourses(search: string): Course[] {
    const normalized = search.trim().toLowerCase();
    if (!normalized) {
      return this.courses;
    }
    return this.courses.filter(course =>
      course.name.toLowerCase().includes(normalized) ||
      course.code.toLowerCase().includes(normalized)
    );
  }

}
