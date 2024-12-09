public class InfoLogger implements ILogger{

    int logLevel;
    ILogger nextLogger;
    public InfoLogger() {
        logLevel = 3;
        nextLogger = new DebugLogger();
    }

    @Override
    public void log(String message, int level) {
        if (level==logLevel) {
            System.out.println("Info logging: " + message );
        }
        else {
            nextLogger.log(message, level);
        }
    }
}
