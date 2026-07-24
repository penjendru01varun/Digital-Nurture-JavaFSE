# Exercise 3: Using Different Appenders

## Task
Write a Java application that demonstrates using different appenders (Console and File) with SLF4J and Logback.

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

## logback.xml Configuration

```xml
<configuration>
    <appender name="console" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <appender name="file" class="ch.qos.logback.core.FileAppender">
        <file>app.log</file>
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <root level="debug">
        <appender-ref ref="console" />
        <appender-ref ref="file" />
    </root>
</configuration>
```

## Solution Code

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.debug("Debug message — appears in console and file");
        logger.info("Info message  — appears in console and file");
        logger.warn("Warn message  — appears in console and file");
        logger.error("Error message — appears in console and file");
    }
}
```

## Output
```
Console and app.log both contain:
DEBUG AppenderExample - Debug message — appears in console and file
INFO  AppenderExample - Info message  — appears in console and file
WARN  AppenderExample - Warn message  — appears in console and file
ERROR AppenderExample - Error message — appears in console and file
```
