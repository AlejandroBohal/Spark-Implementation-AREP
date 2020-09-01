package edu.escuelaing.arep.persistence;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DataBaseConnection {
    public DataBaseConnection(){

    }
    public MongoClient getClient(){
        MongoClientURI uri = new MongoClientURI("mongodb+srv://admin:Hdk0Y6G3Atp9xG3e@cluster0.w4aqr.mongodb.net/Chat?retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        return mongoClient;
    }


}
