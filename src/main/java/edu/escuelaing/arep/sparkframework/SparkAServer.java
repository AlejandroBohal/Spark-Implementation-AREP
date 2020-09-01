package edu.escuelaing.arep.sparkframework;

import edu.escuelaing.arep.persistence.DataBaseTest;
import edu.escuelaing.arep.servers.HTTPServer;

public class SparkAServer {

    public static void main(String[] args){
        HTTPServer server =  new HTTPServer();
        server.start();
        SparkA.get("/lol",(request, response) -> "Hola");
        DataBaseTest db = new DataBaseTest();
        SparkA.get("/database",(request, response) -> db.getExampleMongo().toString());
    }
}
