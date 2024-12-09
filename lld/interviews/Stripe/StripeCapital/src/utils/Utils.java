package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public static List<String> parseRequest(String requestString) {
        List<String> res = new ArrayList<>();
        res.add(requestString.split(": ")[0]);
        String[] remaining = requestString.split(": ")[1].split(",");
        res.addAll(Arrays.asList(remaining));
        return res;
    }
}
