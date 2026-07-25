import { Component, EventEmitter, inject, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { Course } from '../../models/course.model';
import { HighlightDirective } from '../../directives/highlight';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';
import { enrollInCourse, unenrollFromCourse } from '../../store/enrollment/enrollment.actions';
import { selectEnrolledIds } from '../../store/enrollment/enrollment.selectors';

@Component({ selector: 'app-course-card', standalone: true, imports: [CommonModule, HighlightDirective, CreditLabelPipe], templateUrl: './course-card.html', styleUrl: './course-card.css' })
export class CourseCardComponent implements OnChanges {
  @Input() course!: Course;
  @Output() enrollRequested = new EventEmitter<number>();
  isExpanded = false;
  private readonly store = inject(Store);
  readonly enrolledIds$ = this.store.select(selectEnrolledIds);
  constructor(private readonly router: Router) {}
  ngOnChanges(changes: SimpleChanges): void { if (changes['course']) console.log('Course changed:', changes['course'].previousValue, changes['course'].currentValue); }
  cardClasses(enrolled: boolean): Record<string, boolean> { return { 'card--enrolled': enrolled, 'card--full': this.course.credits >= 4, expanded: this.isExpanded }; } // Keeps the template readable while preserving store-driven state.
  get borderColor(): string { return this.course.gradeStatus === 'passed' ? 'green' : this.course.gradeStatus === 'failed' ? 'red' : 'grey'; }
  toggleDetails(): void { this.isExpanded = !this.isExpanded; }
  enroll(enrolled: boolean): void { this.store.dispatch(enrolled ? unenrollFromCourse({ courseId: this.course.id }) : enrollInCourse({ courseId: this.course.id })); this.enrollRequested.emit(this.course.id); }
  openDetail(): void { this.router.navigate(['courses', this.course.id]); }
}
