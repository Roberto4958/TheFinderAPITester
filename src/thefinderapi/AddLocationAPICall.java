/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thefinderapi;

import ResponseData.Response;
import ResponseData.UserResponse;
import com.google.gson.Gson;
import java.io.IOException;

/**
 *
 * @author cancola
 */
public class AddLocationAPICall {
    
    public AddLocationAPICall(){
        
    }
    public Response getResponse(int userID, double latitude, double longitude, String place, String auth)throws IOException{
        ServerConnection SC = new ServerConnection();
        String url = "http://thefinder-1.s4c2qwepti.us-west-2.elasticbeanstalk.com/webresources/addNewLocation/";
        url = url+place+"/"+latitude+"/"+longitude+"/"+userID+"/"+auth;
        String response = SC.downloadUrl("PUT",url);
        
        if(response!= null){
            Gson gson = new Gson();
            Response r = gson.fromJson(response, Response.class);
            return r;
        }else return null;
    }
}
