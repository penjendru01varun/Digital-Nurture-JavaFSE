import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Course } from '../../models/course.model';
import { CourseService } from '../../services/course.service';

@Component({
  selector: 'app-course-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './course-form.html',
  styleUrl: './course-form.css',
})
export class CourseForm implements OnInit {
  private readonly fb = inject(FormBuilder);
  private readonly courseService = inject(CourseService);
  courses: Course[] = [];
  editingId: number | null = null;
  message = '';
  error = '';

  readonly form = this.fb.nonNullable.group({
    name: ['', [Validators.required, Validators.minLength(3)]],
    code: ['', [Validators.required, Validators.pattern(/^[A-Z]{2,4}\d{3}$/)]],
    credits: [3, [Validators.required, Validators.min(1), Validators.max(6)]],
    gradeStatus: ['pending' as Course['gradeStatus'], Validators.required]
  });

  ngOnInit(): void { this.loadCourses(); }

  loadCourses(): void {
    this.courseService.getCourses().subscribe({
      next: courses => this.courses = courses,
      error: error => this.error = error.message
    });
  }

  save(): void {
    if (this.form.invalid) { this.form.markAllAsTouched(); return; }
    const value = this.form.getRawValue();
    const request = this.editingId === null
      ? this.courseService.createCourse(value)
      : this.courseService.updateCourse({ ...value, id: this.editingId });
    request.subscribe({
      next: () => {
        this.message = this.editingId === null ? 'Course created successfully.' : 'Course updated successfully.';
        this.reset();
        this.loadCourses();
      },
      error: () => this.error = 'The course could not be saved. Start JSON Server with npm run api.'
    });
  }

  edit(course: Course): void {
    this.editingId = course.id;
    this.form.setValue({ name: course.name, code: course.code, credits: course.credits, gradeStatus: course.gradeStatus });
    this.message = '';
  }

  remove(course: Course): void {
    if (!window.confirm(`Delete ${course.name}?`)) return;
    this.courseService.deleteCourse(course.id).subscribe({
      next: () => { this.message = 'Course deleted successfully.'; this.loadCourses(); },
      error: () => this.error = 'The course could not be deleted. Start JSON Server with npm run api.'
    });
  }

  reset(): void {
    this.editingId = null;
    this.form.reset({ name: '', code: '', credits: 3, gradeStatus: 'pending' });
    this.form.markAsPristine();
  }
}
