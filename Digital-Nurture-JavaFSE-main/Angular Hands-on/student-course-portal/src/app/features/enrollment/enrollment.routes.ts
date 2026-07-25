import { Routes } from '@angular/router';
import { EnrollmentFormComponent } from '../../pages/enrollment-form/enrollment-form';
import { ReactiveEnrollmentFormComponent } from '../../pages/reactive-enrollment-form/reactive-enrollment-form';
import { unsavedChangesGuard } from '../../guards/unsaved-changes.guard';

export const ENROLLMENT_ROUTES: Routes = [
	{ path: '', component: EnrollmentFormComponent, canDeactivate: [unsavedChangesGuard] },
	{ path: 'reactive', component: ReactiveEnrollmentFormComponent, canDeactivate: [unsavedChangesGuard] }
];
