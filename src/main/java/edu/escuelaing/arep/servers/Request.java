package edu.escuelaing.arep.servers;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private String path;
    private String type;
    private String body;
    Map<String, String> headersMap;
    public Request(){
        this.path = "";
        this.type = "";
        this.headersMap = new HashMap<String, String>();
    }

    public String getPath(){
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Map<String, String> getHeadersMap() {
        return headersMap;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public void setHeader(String key,String value){
        headersMap.put(key,value);
    }
}
