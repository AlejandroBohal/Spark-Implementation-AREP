package edu.escuelaing.arep.sparkframework;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import edu.escuelaing.arep.persistence.Cliente;
import edu.escuelaing.arep.persistence.DataBaseConnection;
import edu.escuelaing.arep.servers.HTTPServer;

import com.google.gson.Gson;
import org.bson.Document;

import java.util.List;


/**
 * The type Spark a server.
 */
public class SparkAServer {

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        HTTPServer server =  new HTTPServer();
        server.setPort(getPort());
        server.start();
        DataBaseConnection dataBase = new DataBaseConnection();
        List<Cliente> clientes= dataBase.getClients();
        System.out.println(clientes);
        SparkA.get("/lol",(request, response) -> "Hola");
        SparkA.get("/clients",(request, response) -> {
            return new Gson().toJson(dataBase.getClients());
        });
        SparkA.post("/clients",(request, response) -> {
            Gson gson = new Gson();
            dataBase.insert(request.getBody());
            return gson.toJson(request.getBody());
        });
    }

    /**
     * Gets port.
     *
     * @return the port
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 36000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}
