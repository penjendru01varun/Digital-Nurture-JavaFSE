# Exercise 2: Parameterized Logging

## Task
Write a Java application that demonstrates parameterized logging using SLF4J.

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

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String user = "Alice";
        int age = 30;

        // Parameterized log — {} placeholders are resolved lazily (no string concat unless needed)
        logger.info("User {} has logged in at age {}", user, age);
        logger.debug("Processing request for user: {}", user);
        logger.warn("User {} has {} failed login attempts", user, 3);
    }
}
```

## Output
```
INFO  ParameterizedLoggingExample - User Alice has logged in at age 30
WARN  ParameterizedLoggingExample - User Alice has 3 failed login attempts
```
