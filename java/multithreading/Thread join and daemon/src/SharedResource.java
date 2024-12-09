public class SharedResource {
    boolean isAvailable;

    SharedResource() {
        isAvailable = false;
    }
    public synchronized void toggleAvailability() {
        try{
            Thread.sleep(10000);
        } catch (Exception ignored) {

        }
        isAvailable = !isAvailable;
    }
    public synchronized void toggleAvailability2 () {
        try{
            Thread.sleep(20000);
        } catch (Exception ignored) {

        }
        isAvailable = !isAvailable;
    }
}
