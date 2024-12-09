import java.util.Map;

public class Main {

    public static void main(String[] args) {
        KeyValuePair keyValuePair = KeyValuePair.getInstance();
        Map<String, Object> value = Map.of("1", 1, "2", "heelo", "3", false);
        Request request1 = new Request("add", "mahfooz", value, null);
        Request request2 = new Request("get", "mahfooz", null, null);
        Request request3 = new Request("getAttribute", "mahfooz", null, "1");
        Request request4 = new Request("delete", "mahfooz", null, null);


        Thread thread1 = new Thread(new Executor(keyValuePair, request1));
        Thread thread2 = new Thread(new Executor(keyValuePair, request2));
        Thread thread3 = new Thread(new Executor(keyValuePair, request3));
        Thread thread4 = new Thread(new Executor(keyValuePair, request4));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
