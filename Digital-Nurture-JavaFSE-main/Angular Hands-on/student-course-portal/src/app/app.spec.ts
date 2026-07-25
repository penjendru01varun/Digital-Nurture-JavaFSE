import { ComponentFixture, TestBed } from '@angular/core/testing';
import { App } from './app';
import { appConfig } from './app.config';

describe('App startup', () => {
  let fixture: ComponentFixture<App>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({ imports: [App], providers: appConfig.providers || [] }).compileComponents();
    fixture = TestBed.createComponent(App);
  });

  it('creates the portal shell', () => {
    fixture.detectChanges();
    expect(fixture.componentInstance).toBeTruthy();
  });
});
