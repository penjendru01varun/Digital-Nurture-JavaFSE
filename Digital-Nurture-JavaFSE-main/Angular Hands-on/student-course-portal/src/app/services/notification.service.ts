import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
@Injectable()
export class NotificationService {
  private readonly messageSubject = new BehaviorSubject('');
  readonly message$ = this.messageSubject.asObservable();
  show(message: string): void { this.messageSubject.next(message); }
}
