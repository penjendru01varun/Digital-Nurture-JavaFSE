import 'zone.js';
import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';

bootstrapApplication(App, appConfig)
  .catch((err) => {
    console.error(err);
    document.body.innerHTML = `<pre style="padding:20px;color:#b00020;background:white">Application startup error: ${String(err)}</pre>`;
  });
