import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, map, retry, tap, throwError } from 'rxjs';
import { Course } from '../models/course.model';

@Injectable({ providedIn: 'root' })
export class CourseService {
  private readonly apiUrl = 'http://localhost:3000/courses';

  constructor(private readonly http: HttpClient) {}

  private normalizeCourse(course: Course & { id: string | number }): Course {
    return {
      ...course,
      id: Number(course.id)
    };
  }

  getCourses(): Observable<Course[]> {
    return this.http.get<(Course & { id: string | number })[]>(this.apiUrl).pipe(
      map(courses => courses.map(course => this.normalizeCourse(course)).filter(course => course.credits > 0)),
      tap(courses => console.log('Courses loaded:', courses.length)),
      retry(2),
      catchError(() => throwError(() => new Error('Failed to load courses. Please try again.')))
    );
  }

  getCourseById(id: number): Observable<Course> {
    return this.http.get<Course & { id: string | number }>(`${this.apiUrl}/${id}`).pipe(
      map(course => this.normalizeCourse(course))
    );
  }

  createCourse(course: Omit<Course, 'id'>): Observable<Course> { return this.http.post<Course>(this.apiUrl, course); }
  updateCourse(course: Course): Observable<Course> { return this.http.put<Course>(`${this.apiUrl}/${course.id}`, course); }
  deleteCourse(id: number): Observable<void> { return this.http.delete<void>(`${this.apiUrl}/${id}`); }
}
