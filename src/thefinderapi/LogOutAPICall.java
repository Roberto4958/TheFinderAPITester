/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thefinderapi;

import ResponseData.Response;
import com.google.gson.Gson;
import java.io.IOException;

/**
 *
 * @author cancola
 */
public class LogOutAPICall {
    
    public LogOutAPICall(){   
    }
    
    public Response getResponse(int id, String auth)throws IOException{
        ServerConnection SC = new ServerConnection();
        String url = "http://thefinder-1.s4c2qwepti.us-west-2.elasticbeanstalk.com/webresources/logOut/";
        String response = SC.downloadUrl("POST", url+id+"/"+auth);
        
        Gson gson = new Gson();
        Response r = gson.fromJson(response, Response.class);
        return r;
    }
}
