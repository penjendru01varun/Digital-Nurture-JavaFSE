import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
@Injectable({ providedIn: 'root' })
export class LoadingService { readonly isLoading$ = new BehaviorSubject(false); }
