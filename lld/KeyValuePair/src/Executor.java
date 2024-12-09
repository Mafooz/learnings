import java.util.Map;

public class Executor implements Runnable {

    KeyValuePair keyValuePair;
    Request request;


    public Executor(KeyValuePair keyValuePair, Request request) {
        this.keyValuePair = keyValuePair;
        this.request = request;
    }

    public void run() {
            switch (request.getOperation()) {
                case "add":
                    keyValuePair.add(request.getKey(), request.getValue());
                    break;
                case "update":
                    keyValuePair.update(request.getKey(), request.getValue());
                    break;
                case "getAttribute":
                    System.out.println("Running getAttribute");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Object object = keyValuePair.getAttributeValue(request.getKey(), request.getAttribute());
                    break;
                case "get":
                    System.out.println("Running get");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    keyValuePair.get(request.getKey());
                    break;
                case "delete":
                    try {
                        Thread.sleep(1001);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    keyValuePair.delete(request.getKey());
                    break;
            }
    }
}
