module.exports = function (config) {
  config.set({
    basePath: '',
    frameworks: ['jasmine', '@angular-devkit/build-angular'],
    plugins: [require('karma-jasmine'), require('karma-chrome-launcher'), require('karma-jasmine-html-reporter'), require('karma-coverage'), require('@angular-devkit/build-angular/plugins/karma')],
    client: { clearContext: false },
    reporters: ['progress', 'kjhtml'],
    customLaunchers: {
      ChromeHeadlessNoGpu: {
        base: 'ChromeHeadless',
        flags: ['--disable-gpu', '--no-first-run', '--no-default-browser-check']
      }
    },
    browsers: ['ChromeHeadlessNoGpu'],
    restartOnFileChange: true
  });
};
