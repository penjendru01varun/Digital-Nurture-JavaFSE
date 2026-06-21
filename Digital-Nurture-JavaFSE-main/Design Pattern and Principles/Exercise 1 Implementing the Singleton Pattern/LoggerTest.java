public class LoggerTest {
    
    public static void main(String[] args) {
        System.out.println("=== Starting Singleton Logger Test ===\n");
        
        System.out.println("Test 1: Getting first Logger instance...");
        Logger logger1 = Logger.getInstance();
        logger1.info("Application started");
        logger1.info("User logged in");
        
        System.out.println("\nTest 2: Getting second Logger instance...");
        Logger logger2 = Logger.getInstance();
        logger2.warning("Disk space low");
        logger2.info("Processing data...");
        
        System.out.println("\nTest 3: Getting third Logger instance...");
        Logger logger3 = Logger.getInstance();
        logger3.error("Database connection failed");
        logger3.info("Attempting reconnect...");
        
        System.out.println("\n=== Verification Results ===");
        System.out.println("logger1 == logger2: " + (logger1 == logger2));
        System.out.println("logger2 == logger3: " + (logger2 == logger3));
        System.out.println("logger1 == logger3: " + (logger1 == logger3));
        
        System.out.println("\nInstance count: " + Logger.getInstanceCount());
        System.out.println("Expected: 1");
        System.out.println("Singleton pattern is " + 
            (Logger.getInstanceCount() == 1 ? "WORKING" : "FAILED"));
        
        System.out.println("\n=== Complete Log Buffer ===");
        System.out.println(logger1.getLogBuffer());
        
        System.out.println("=== Additional Verification ===");
        Logger logger4 = Logger.getInstance();
        Logger logger5 = Logger.getInstance();
        logger4.info("This is a test from logger4");
        logger5.info("This is a test from logger5");
        
        System.out.println("\nAll references point to same instance: " + 
            (logger4 == logger5 && logger5 == logger1));
        System.out.println("Total instances created: " + Logger.getInstanceCount());
        
        System.out.println("\n=== Thread Safety Test ===");
        testThreadSafety();
    }
    
    private static void testThreadSafety() {
        final int THREAD_COUNT = 5;
        Thread[] threads = new Thread[THREAD_COUNT];
        
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                Logger log = Logger.getInstance();
                log.info("Thread " + threadId + " using logger instance");
                System.out.println("Thread " + threadId + 
                    " - Logger instance hash: " + log.hashCode());
            });
            threads[i].start();
        }
        
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("\nAll threads got same instance: " + 
            (Logger.getInstanceCount() == 1));
    }
}