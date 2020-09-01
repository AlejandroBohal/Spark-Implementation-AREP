package edu.escuelaing.arep.sparkframework;

import edu.escuelaing.arep.servers.Request;
import edu.escuelaing.arep.servers.Response;

import java.util.function.BiFunction;


public class SparkA {


    public static Handler handler = new Handler();
    public static void get (String path, BiFunction<Request, Response,String> f){
        handler.getEndPoints().put("GET"+path,f);
    }
    public static void post (String path, BiFunction<Request, Response,String> f){
        handler.getEndPoints().put("POST"+path,f);
    }
    public static Response exec(Request request){
        return handler.execute(request);
    }
    public static void setStaticResourcesPath(String path){

    }
}
