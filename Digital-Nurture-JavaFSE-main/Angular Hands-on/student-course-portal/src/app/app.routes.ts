import { Routes } from '@angular/router';

import { Home } from './pages/home/home';
import { CoursesLayoutComponent } from './pages/courses-layout/courses-layout';
import { CourseListComponent } from './pages/course-list/course-list';
import { StudentProfile } from './pages/student-profile/student-profile';
import { CourseDetail } from './pages/course-detail/course-detail';
import { CourseForm } from './pages/course-form/course-form';
import { ReactiveEnrollmentFormComponent } from './pages/reactive-enrollment-form/reactive-enrollment-form';
import { NotFoundComponent } from './pages/not-found/not-found';
import { authGuard } from './guards/auth.guard';
import { unsavedChangesGuard } from './guards/unsaved-changes.guard';

export const routes: Routes = [
  { path: '', pathMatch: 'full', component: Home },
  {
    path: 'courses',
    component: CoursesLayoutComponent,
    children: [
      { path: '', component: CourseListComponent },
      { path: 'manage', component: CourseForm, canDeactivate: [unsavedChangesGuard] },
      { path: ':id', component: CourseDetail }
    ]
  },
  { path: 'profile', component: StudentProfile, canActivate: [authGuard] },
  {
    path: 'enroll',
    loadChildren: () => import('./features/enrollment/enrollment.routes').then(m => m.ENROLLMENT_ROUTES),
    canActivate: [authGuard]
  },
  {
    path: 'enroll-reactive',
    component: ReactiveEnrollmentFormComponent,
    canActivate: [authGuard],
    canDeactivate: [unsavedChangesGuard]
  },
  { path: '**', component: NotFoundComponent },
];
