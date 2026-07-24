# Exercise 5: Implementing the Decorator Pattern

## Objective
Develop a notification system where notifications can be sent via multiple channels (e.g., Email, SMS, Slack) using the Decorator Pattern to add functionalities dynamically.

## Technologies Used
- Java 17

## Files Included
- `Notifier.java`: The component interface for sending notifications.
- `EmailNotifier.java`: The concrete component implementing `Notifier`.
- `NotifierDecorator.java`: Abstract decorator class implementing `Notifier` and holding a reference to a `Notifier` object.
- `SMSNotifierDecorator.java`, `SlackNotifierDecorator.java`: Concrete decorator classes that extend `NotifierDecorator` to add additional notification channels.
- `TestDecorator.java`: The test class demonstrating sending notifications via multiple channels using decorators.

## Output Screenshot
```text
--- Sending via Email only ---
Sending Email: System Update 1.0

--- Sending via Email and SMS ---
Sending Email: System Update 2.0
Sending SMS: System Update 2.0

--- Sending via Email, SMS, and Slack ---
Sending Email: System Update 3.0 (CRITICAL)
Sending SMS: System Update 3.0 (CRITICAL)
Sending Slack message: System Update 3.0 (CRITICAL)
```
