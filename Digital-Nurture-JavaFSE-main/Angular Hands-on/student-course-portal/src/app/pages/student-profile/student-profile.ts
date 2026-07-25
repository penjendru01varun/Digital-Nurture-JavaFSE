import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';
import { selectEnrolledCourses } from '../../store/enrollment/enrollment.selectors';

@Component({
  selector: 'app-student-profile',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './student-profile.html',
  styleUrl: './student-profile.css'
})
export class StudentProfile {
  readonly enrolledCourses$ = inject(Store).select(selectEnrolledCourses);

  student = {

    name: "Thanvika",

    email: "thanvika@gmail.com",

    department: "Computer Science",

    semester: 6,

    cgpa: 8.9,

    phone: "9876543210"

  };

}
