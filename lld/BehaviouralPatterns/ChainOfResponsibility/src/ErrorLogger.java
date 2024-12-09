public class ErrorLogger implements ILogger {

    int logLevel;
    ILogger nextLogger;
    public ErrorLogger() {
        logLevel = 1;
        nextLogger = new WarningLogger();
    }

    @Override
    public void log(String message, int level) {
        if (level==logLevel) {
            System.out.println("Error logging: " + message );
        }
        else {
            nextLogger.log(message, level);
        }
    }
}
