class Logger {
    void log(String message) {
        System.out.println("[INFO] " + message);
    }

    void log(String message, int code) {
        System.out.println("[INFO-" + code + "] " + message);
    }

    void log(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}

public class CompileTimeLogger {
    public static void main(String[] args) {
        Logger logger = new Logger();

        logger.log("Application started");
//        logger.log("Task completed", 200);
//        logger.log(new RuntimeException("Something went wrong"));
    }
}
