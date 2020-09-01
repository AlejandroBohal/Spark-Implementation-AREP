package edu.escuelaing.arep.persistence;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.LinkedList;
import java.util.List;

public class DataBaseTest {
    public DataBaseTest(){
    }
    public List<Cliente> getExampleMongo(){
        List<Cliente> clientes = new LinkedList<Cliente>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        MongoDatabase database = dataBaseConnection.getClient().getDatabase("Arep");
        MongoCollection<Document> collection = database.getCollection("example");
        for (Document d: collection.find()){
            clientes.add(new Cliente(d.get("Cliente").toString(),d.get("Empresa").toString()));
        }
        return  clientes;
    }
}
