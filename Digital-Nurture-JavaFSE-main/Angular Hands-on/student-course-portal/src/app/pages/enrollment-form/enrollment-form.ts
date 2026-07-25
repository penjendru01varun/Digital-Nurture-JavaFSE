import { Component, ViewChild } from '@angular/core'; import { CommonModule } from '@angular/common'; import { FormsModule, NgForm } from '@angular/forms';

@Component({ selector: 'app-enrollment-form', standalone: true, imports: [CommonModule, FormsModule], templateUrl: './enrollment-form.html', styleUrl: './enrollment-form.css' })
export class EnrollmentFormComponent {
	@ViewChild('enrollForm') enrollForm?: NgForm;
	submitted = false;
	model = { studentName: '', studentEmail: '', courseId: null as number | null, preferredSemester: 'Odd', agreeToTerms: false };
	onSubmit(form: NgForm): void {
		if (form.valid) {
			this.submitted = true;
			form.form.markAsPristine();
		}
	}
	reset(form: NgForm): void {
		form.resetForm({ preferredSemester: 'Odd', agreeToTerms: false });
		this.submitted = false;
	}
}
