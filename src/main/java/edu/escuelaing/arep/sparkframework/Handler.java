package edu.escuelaing.arep.sparkframework;

import edu.escuelaing.arep.servers.Request;
import edu.escuelaing.arep.servers.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Handler {
    Map<String, BiFunction<Request,Response,String>> endPoints;
    public Handler(){
        this.endPoints = new HashMap<String, BiFunction<Request,Response,String>>();
    }
    public Response execute(Request request){
        String endPoint = request.getType() +request.getPath();
        if(endPoints.containsKey(endPoint)){
            Response response = new Response();
            response.setBody(endPoints.get(endPoint).apply(request,response));
            return response;
        }else{
            return null;
        }
    }
    public Map<String, BiFunction<Request, Response, String>> getEndPoints() {
        return endPoints;
    }


}
