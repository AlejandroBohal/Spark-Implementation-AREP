package edu.escuelaing.arep.servers;
import edu.escuelaing.arep.sparkframework.SparkA;

import java.net.*;
import java.io.*;


public class HTTPServer extends Thread{

    private int port = 36000;
    private String staticPath = "src/main/resources";
    private boolean running;
    public HTTPServer() {
    }
    public HTTPServer(int port) {
        this.port = port;
    }
    public void run() {
        try{
        ServerSocket serverSocket = null;
        try {
            System.out.println("Running on port" + port);
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + port);
            System.exit(1);
        }
        running = true;
        while (running) {
            try {
                Socket clientSocket = null;
                try {
                    clientSocket = serverSocket.accept();
                } catch (IOException e) {
                    System.err.println("Accept failed.");
                    System.exit(1);
                }
                processRequest(clientSocket);
                clientSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
            serverSocket.close();
        } catch (IOException e){
            System.out.println("f");
        }
    }

    private void processRequest(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        Request req = new Request();
        while ((inputLine = in.readLine()) != null) {
            req.setType(inputLine.split(" ")[0]);
            req.setPath(inputLine.split(" ")[1]);
            if (!in.ready()) {
                break;
            }
            if(inputLine.length() == 0){
                break;
            }

        }
        if(req.getType().equals("POST")){
            StringBuilder body = new StringBuilder();
            while (in.ready() && in.read()!=-1) {
                body.append(in.read());
            }
            req.setBody(body.toString());

        }
        if(!req.getType().equals("") || !req.getBody().equals("") ){
            createResponse(req, new PrintStream(
                    clientSocket.getOutputStream(), true));
        }in.close();

    }
    private void createResponse(Request req, PrintStream out) {
        if (req.getPath().equals("/")){
            req.setPath("/index.html");
        }
        Response res = new Response();
        Response response = SparkA.exec(req);
        try {
            if (response != null){
                response.setDefaultStatus(req);
                out.print(response.getStatus() + "Content-type: " + response.getContentType() + "\r\n\r\n");
                out.print(response.getBody());
                out.close();
            }else{
                res.setDefaultStatus(req);
                if(req.getType().equals("GET")) {
                    getResource(res, req.getPath(), out);
                }
            }
            out.close();
        } catch (IOException e) {
            res.setStatus(Response.NOT_FOUND);
            out.close();
        }
        out.close();
    }
    private void getResource(Response res, String fileName, PrintStream out) throws IOException {
        File file = new File(staticPath + fileName);
        if(fileName.equals("/")){
            fileName = "index.html";
        }
        if (file.exists()) {
            String fd = staticPath + fileName;
            InputStream f = new FileInputStream(fd);
            out.print(res.getStatus() + "Content-type: " + res.getContentType() + "\r\n\r\n");
            byte[] a = new byte[4096];
            int n;
            while ((n = f.read(a)) > 0) {
                out.write(a, 0, n);
            }
        }else{
            out.print(Response.NOT_FOUND);
            out.close();
        }
        out.close();
    }

    public void setStaticPath(String staticPath) {
        this.staticPath = staticPath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}