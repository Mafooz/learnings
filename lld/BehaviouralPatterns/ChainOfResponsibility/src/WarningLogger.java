public class WarningLogger implements ILogger{

    int logLevel;
    ILogger nextLogger;
    public WarningLogger() {
        logLevel = 2;
        nextLogger = new InfoLogger();
    }

    @Override
    public void log(String message, int level) {
        if (level==logLevel) {
            System.out.println("Warning logging: " + message );
        }
        else {
            nextLogger.log(message, level);
        }
    }
}
