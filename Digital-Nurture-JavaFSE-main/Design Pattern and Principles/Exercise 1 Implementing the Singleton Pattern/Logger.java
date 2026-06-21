public class Logger {
    
    private static Logger instance = null;
    private static int instanceCount = 0;
    private String logBuffer = "";
    
    private Logger() {
        instanceCount++;
        System.out.println("Logger instance created. Total instances: " + instanceCount);
        logBuffer = "=== Log Session Started ===\n";
    }
    
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    
    public void info(String message) {
        String logEntry = "[INFO] " + getTimestamp() + " - " + message + "\n";
        logBuffer += logEntry;
        System.out.print(logEntry);
    }
    
    public void warning(String message) {
        String logEntry = "[WARNING] " + getTimestamp() + " - " + message + "\n";
        logBuffer += logEntry;
        System.out.print(logEntry);
    }
    
    public void error(String message) {
        String logEntry = "[ERROR] " + getTimestamp() + " - " + message + "\n";
        logBuffer += logEntry;
        System.err.print(logEntry);
    }
    
    private String getTimestamp() {
        return java.time.LocalDateTime.now().format(
            java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );
    }
    
    public String getLogBuffer() {
        return logBuffer;
    }
    
    public void clearLog() {
        logBuffer = "=== Log Session Started ===\n";
    }
    
    public static int getInstanceCount() {
        return instanceCount;
    }
}