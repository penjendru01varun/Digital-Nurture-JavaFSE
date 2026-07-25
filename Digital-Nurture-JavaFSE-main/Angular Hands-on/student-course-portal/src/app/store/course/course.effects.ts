import { inject, Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { catchError, map, of, switchMap } from 'rxjs';
import { CourseService } from '../../services/course.service';
import { loadCourses, loadCoursesFailure, loadCoursesSuccess } from './course.actions';

@Injectable()
export class CourseEffects {
  private readonly actions$ = inject(Actions);
  private readonly courseService = inject(CourseService);

  readonly loadCourses$ = createEffect(() =>
    this.actions$.pipe(
      ofType(loadCourses),
      switchMap(() => this.courseService.getCourses().pipe(
        map(courses => loadCoursesSuccess({ courses })),
        catchError(error => of(loadCoursesFailure({ error: error.message })))
      ))
    )
  );
}
