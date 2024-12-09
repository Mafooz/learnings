package model;

import utils.API;
import utils.Utils;

import java.util.List;

public class Request {

    private final API api;
    List<String> inputParams;

    public API getApi() {
        return api;
    }

    public List<String> getInputParams() {
        return inputParams;
    }

    public Request(String inputString) {
        List<String> requestParams = Utils.parseRequest(inputString);
        api = API.valueOf(requestParams.getFirst());
        inputParams = requestParams.subList(1, requestParams.size());
    }
}
