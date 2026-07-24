# Exercise 7: Implementing the Observer Pattern

## Objective
Develop a stock market monitoring application where multiple clients need to be notified whenever stock prices change using the Observer Pattern.

## Technologies Used
- Java 17

## Files Included
- `Stock.java`: Subject interface with methods to register, deregister, and notify observers.
- `StockMarket.java`: Concrete subject that maintains a list of observers and notifies them of price changes.
- `Observer.java`: Observer interface with an `update()` method.
- `MobileApp.java`, `WebApp.java`: Concrete observers that react to stock price updates.
- `TestObserver.java`: Test class demonstrating the registration and notification of observers.

## Output Screenshot
```text
--- First price update ---
MobileApp Notification -> Stock: AAPL is now $155.0
WebApp Dashboard -> Stock: AAPL is now $155.0

--- Second price update ---
WebApp Dashboard -> Stock: AAPL is now $160.0
```
