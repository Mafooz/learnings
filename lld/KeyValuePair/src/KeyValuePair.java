import java.util.HashMap;
import java.util.Map;

public class KeyValuePair {

    Map<String, Map<String, Object>> keyValue;

    private static KeyValuePair keyValuePair;
    private KeyValuePair() {
        keyValue = new HashMap<>();
    }

    public static KeyValuePair getInstance() {
        if (keyValuePair==null) {
            keyValuePair = new KeyValuePair();
        }
        return keyValuePair;
    }

    // Get value using key
    public Map<String, Object> get(String key) {
        if (keyValue.containsKey(key)) {
            synchronized (this) {
                System.out.println("get Thread is " + Thread.currentThread().getName());
                System.out.println("Getting value for key " + key);
                Map<String, Object> value = keyValue.getOrDefault(key, null);
                System.out.println("Values for key " + key);
                if (value==null) {
                    System.out.println("Value is null");
                }
                else {
                    for(String attributes: value.keySet()) {
                        System.out.println(attributes + ": " + value.get(attributes));
                    }
                }
                return value;
            }
        }
        return null;
    }

    public Object getAttributeValue(String key, String attribute) {
        Map<String, Object> value = get(key);
        if (value!=null && value.containsKey(attribute)) {
            synchronized (this) {
                System.out.println("getAttribute Thread is " + Thread.currentThread().getName());
                System.out.println("Getting attribute " + attribute + " of key " + key);
                Object object = value.getOrDefault(attribute, null);
                System.out.println("Attribute " + attribute + " of key " + key + " is " + object);
                return object;
            }
        }
        return null;
    }

    // Add value to key
    public synchronized void add(String key, Map<String, Object> value) {
        System.out.println("add Thread is " + Thread.currentThread().getName());
        System.out.println("Adding to Map " + key);
        if (!value.containsKey(key)) {
            keyValue.put(key, value);
        }
        System.out.println("Added to Map " + key);
    }

    //Update value
    public synchronized void update(String key, Map<String, Object> value) {
        System.out.println("update Thread is " + Thread.currentThread().getName());
        System.out.println("Updating Map with key " + key);
        keyValue.put(key, value);
        System.out.println("Updated Map with key " + key);
    }


    // Delete key
    public synchronized void delete(String key) {
        System.out.println("delete Thread is " + Thread.currentThread().getName());
        System.out.println("Deleting key " + key + " from Map");
        keyValue.remove(key);
        System.out.println("Deleted key " + key + " from Map");
    }

}
