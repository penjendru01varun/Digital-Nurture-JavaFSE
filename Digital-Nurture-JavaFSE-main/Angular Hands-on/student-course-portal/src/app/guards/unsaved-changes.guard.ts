import { CanDeactivateFn } from '@angular/router';
/** Components protected by this guard expose the form that holds their edits. */
export interface HasUnsavedChanges { enrollForm?: { dirty: boolean }; form?: { dirty: boolean }; }
export const unsavedChangesGuard: CanDeactivateFn<HasUnsavedChanges> = component => {
  const form = component.enrollForm ?? component.form;
  if (!form) {
    return true;
  }
  return !form.dirty || window.confirm('You have unsaved changes. Leave?');
};
