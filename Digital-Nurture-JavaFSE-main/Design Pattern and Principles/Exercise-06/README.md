# Exercise 6: Implementing the Proxy Pattern

## Objective
Develop an image viewer application that loads images from a remote server using the Proxy Pattern to add lazy initialization and caching.

## Technologies Used
- Java 17

## Files Included
- `Image.java`: Subject interface representing an image.
- `RealImage.java`: Real subject class that implements `Image` and loads an image from a remote server.
- `ProxyImage.java`: Proxy class that implements `Image`, holds a reference to `RealImage`, and provides lazy initialization and caching.
- `TestProxy.java`: Test class demonstrating the use of `ProxyImage` to load and display images efficiently.

## Output Screenshot
```text
--- First call (image1) ---
Loading image photo1.jpg from remote server...
Displaying photo1.jpg

--- Second call (image1) ---
Displaying photo1.jpg

--- First call (image2) ---
Loading image photo2.jpg from remote server...
Displaying photo2.jpg
```
