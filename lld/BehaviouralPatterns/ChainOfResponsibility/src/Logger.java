public class Logger implements ILogger{

    @Override
    public void log(String message, int level) {
        new ErrorLogger().log(message, level);
    }
}
