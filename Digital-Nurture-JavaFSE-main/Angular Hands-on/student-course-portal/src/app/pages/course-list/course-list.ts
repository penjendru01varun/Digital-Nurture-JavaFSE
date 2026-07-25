import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { combineLatest, Observable, Subject, switchMap, map } from 'rxjs';
import { Store } from '@ngrx/store';
import { Course } from '../../models/course.model';
import { CourseCardComponent } from '../../components/course-card/course-card';
import { EnrollmentService } from '../../services/enrollment.service';
import { loadCourses } from '../../store/course/course.actions';
import { selectAllCourses, selectCoursesError, selectCoursesLoading } from '../../store/course/course.selectors';

@Component({ selector: 'app-course-list', standalone: true, imports: [CommonModule, FormsModule, CourseCardComponent], templateUrl: './course-list.html', styleUrl: './course-list.css' })
export class CourseListComponent implements OnInit {
  private readonly store = inject(Store);
  filteredCourses$: Observable<Course[]>;
  isLoading$ = this.store.select(selectCoursesLoading);
  errorMessage$ = this.store.select(selectCoursesError);
  selectedCourseId?: number;
  private readonly selectedCourse = new Subject<number>();
  searchTerm = '';

  constructor(private readonly enrollmentService: EnrollmentService, private readonly router: Router, private readonly route: ActivatedRoute) {
    this.filteredCourses$ = combineLatest([this.store.select(selectAllCourses), this.route.queryParamMap]).pipe(
      map(([courses, params]) => {
        const search = params.get('search')?.trim().toLowerCase() ?? '';
        this.searchTerm = params.get('search') ?? '';
        if (!search) {
          return courses;
        }
        return courses.filter(course =>
          course.name.toLowerCase().includes(search) || course.code.toLowerCase().includes(search)
        );
      })
    );
  }

  ngOnInit(): void {
    this.store.dispatch(loadCourses());
    this.selectedCourse.pipe(switchMap(id => this.enrollmentService.getStudentsByCourse(id))).subscribe();
  }

  trackByCourseId(_: number, course: Course): number {
    return course.id;
  }

  updateSearch(): void {
    this.router.navigate(['courses'], { queryParams: { search: this.searchTerm || null } });
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
    this.selectedCourse.next(courseId);
  }
}
