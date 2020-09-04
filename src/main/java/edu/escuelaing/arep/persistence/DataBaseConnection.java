package edu.escuelaing.arep.persistence;

import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.*;


/**
 * The type Data base connection.
 */
public class DataBaseConnection {

    /**
     * The Uri.
     */
    MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://admin:IMeRb2wY5S1MdlDA@cluster0.w4aqr.mongodb.net/Arep?retryWrites=true&w=majority");
    /**
     * The Mongo client.
     */
    MongoClient mongoClient = new MongoClient(uri);
    /**
     * The Database.
     */
    MongoDatabase database = mongoClient.getDatabase("Arep");
    /**
     * The Collection.
     */
    MongoCollection<Document> collection = database.getCollection("example");

    /**
     * Get client mongo client.
     *
     * @return the mongo client
     */
    public  MongoClient getClient(){
        return mongoClient;
    }

    /**
     * Gets clients.
     *
     * @return the clients
     */
    public List<Cliente> getClients() {
        List<Cliente> clientes = new ArrayList<>();
        for (Document d : collection.find()) {
            clientes.add(new Cliente(d.get("nombre").toString(), Integer.parseInt(d.get("edad").toString()), d.get("empresa").toString()));
        }
        return clientes;
    }

    /**
     * Get collection mongo collection.
     *
     * @return the mongo collection
     */
    public MongoCollection<Document> getCollection(){
        return collection;
    }

    /**
     * Insert.
     *
     * @param data the data
     */
    public void insert (String data){
        Gson gson= new Gson();
        Cliente cliente = gson.fromJson(data, Cliente.class);
        System.out.println(data);
        Document document=new Document();
        document.put("nombre",cliente.getNombre());
        document.put("edad",cliente.getEdad());
        document.put("empresa",cliente.getEmpresa());
        collection.insertOne(document);
    }


}