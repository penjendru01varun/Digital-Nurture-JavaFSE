import { createReducer, on } from '@ngrx/store';
import { enrollInCourse, setEnrolledCourses, unenrollFromCourse } from './enrollment.actions';
export interface EnrollmentState { enrolledCourseIds: number[]; }
export const enrollmentReducer = createReducer<EnrollmentState>({ enrolledCourseIds: [] }, on(enrollInCourse, (s, { courseId }) => ({ enrolledCourseIds: [...s.enrolledCourseIds, courseId] })), on(unenrollFromCourse, (s, { courseId }) => ({ enrolledCourseIds: s.enrolledCourseIds.filter(id => id !== courseId) })), on(setEnrolledCourses, (_, { courseIds }) => ({ enrolledCourseIds: courseIds })));
