public class DebugLogger implements ILogger {

    int logLevel;
    ILogger nextLogger;
    public DebugLogger() {
        logLevel = 4;
        nextLogger = null;
    }

    @Override
    public void log(String message, int level) {
        if (level==logLevel) {
            System.out.println("Debug logging: " + message );
        }
    }
}
