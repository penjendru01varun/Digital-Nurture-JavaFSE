
import { Component, OnDestroy, inject } from '@angular/core';
import { CommonModule, AsyncPipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { switchMap, map } from 'rxjs';
import { CourseService } from '../../services/course.service';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';

@Component({
  selector: 'app-course-detail',
  standalone: true,
  imports: [CommonModule, AsyncPipe, CreditLabelPipe],
  templateUrl: './course-detail.html',
  styleUrl: './course-detail.css'
})
export class CourseDetail implements OnDestroy {
  private readonly route = inject(ActivatedRoute);
  private readonly courseService = inject(CourseService);

  readonly course$ = this.route.paramMap.pipe(
    map(p => Number(p.get('id'))),
    switchMap(id => this.courseService.getCourseById(id))
  );

  ngOnDestroy(): void {
    console.log('CourseDetail destroyed');
  }
}