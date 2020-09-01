package edu.escuelaing.arep.servers;

public class Response {
    private String contentType;
    private String status;
    private String body;
    public static final String NOT_FOUND = "HTTP/1.0 404 Not Found \r\n" + "Content-type: text/html" + "\r\n\r\n"+ "404 File not found";
    public static final String OK = "HTTP/1.0 200 OK\r\n";
    public Response(){
        this.contentType = "text/plain";
        this.status = "";
        this.body = "";
    }
    public String getContentType(){
        return this.contentType;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setContentType(String filename){
        if (filename.endsWith(".html") || filename.endsWith(".htm")){
            this.contentType =  "text/html";
        }
        if (filename.endsWith(".css")) {
            this.contentType = "text/css";
        }
        else if (filename.endsWith(".jpg") ||  filename.endsWith(".jpeg")){
            this.contentType = "image/jpeg";
        }
        else if (filename.endsWith(".gif")){
            this.contentType = "image/gif";
        }
        else if (filename.endsWith(".class")){
            this.contentType = "application/octet-stream";
        }
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDefaultStatus(Request req) {
        this.setContentType(req.getPath());
        this.setStatus(Response.OK);
    }
}
