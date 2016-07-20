/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thefinderapi;

import ResponseData.LocationResponse;
import com.google.gson.Gson;
import java.io.IOException;

/**
 *
 * @author cancola
 */
public class FindLocationAPICall {
    
    public FindLocationAPICall(){
        
    }
    
    public LocationResponse getResponse(int id, String auth) throws IOException{
        ServerConnection SC = new ServerConnection();
        String url = "http://thefinder-1.s4c2qwepti.us-west-2.elasticbeanstalk.com/webresources/findLocation/";
        String response = SC.downloadUrl("GET", url+id+"/"+auth);
        
        Gson gson = new Gson();
        LocationResponse r = gson.fromJson(response, LocationResponse.class);
        return r;
    }
    
}
