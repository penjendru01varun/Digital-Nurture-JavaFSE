import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from '../models/student.model';

@Injectable({ providedIn: 'root' })
export class EnrollmentService {
  constructor(private readonly http: HttpClient) {}
  getStudentsByCourse(courseId: number): Observable<Student[]> { return this.http.get<Student[]>(`http://localhost:3000/enrollments?courseId=${courseId}`); }
}
