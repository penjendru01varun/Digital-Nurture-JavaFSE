# Exercise 9: Implementing the Command Pattern

## Objective
Develop a home automation system where commands can be issued to turn devices on or off using the Command Pattern.

## Technologies Used
- Java 17

## Files Included
- `Command.java`: Command interface with an `execute()` method.
- `Light.java`: Receiver class that performs the actual operations.
- `LightOnCommand.java`, `LightOffCommand.java`: Concrete commands encapsulating requests to turn the light on and off.
- `RemoteControl.java`: Invoker class that stores and executes the commands.
- `TestCommand.java`: Test class demonstrating issuing commands using the `RemoteControl`.

## Output Screenshot
```text
--- Pressing ON button ---
The light is ON.

--- Pressing OFF button ---
The light is OFF.
```
