# Exercise 1: Logging Error Messages and Warning Levels

## Task
Write a Java application that demonstrates logging error messages and warning levels using SLF4J.

## Dependencies (pom.xml)

```xml
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.30</version>
</dependency>
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.3</version>
</dependency>
```

## Solution Code

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }
}
```

## Output
```
ERROR LoggingExample - This is an error message
WARN  LoggingExample - This is a warning message
```
