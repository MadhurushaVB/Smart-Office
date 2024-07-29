class Logger {
    private static Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

public class SingletonPattern{
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("This is a log message");

        Logger logger2 = Logger.getInstance();
        logger2.log("This is another log message");

        System.out.println(logger == logger2); 
    }
}
