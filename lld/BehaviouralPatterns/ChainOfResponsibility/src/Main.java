public class Main {
    public static void main(String[] args) {
        ILogger logger = new Logger();

        logger.log("This is first log", 1);
        logger.log("This is second log", 2);
        logger.log("This is third log", 3);
        logger.log("This is fourth log", 4);
        logger.log("This is fifth log", 5);
    }
}
