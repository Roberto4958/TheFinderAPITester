/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thefinderapi;

import ResponseData.UserResponse;
import com.google.gson.Gson;
import java.io.IOException;

/**
 *
 * @author cancola
 */
public class CreateAccountAPICall {
    
    public CreateAccountAPICall(){
    }
    
    public UserResponse getResponse(String userName, String password, String firstName, String lastName)throws IOException{
        ServerConnection SC = new ServerConnection();
        String url = "http://thefinder-1.s4c2qwepti.us-west-2.elasticbeanstalk.com/webresources/createAccount/";
        url = url+userName+"/"+password+"/"+firstName+"/"+lastName;
        String response = SC.downloadUrl("PUT", url);
        
        if(response!= null){
            Gson gson = new Gson();
            UserResponse  r = gson.fromJson(response, UserResponse.class);
            return r;
        }else return null;
    }
}
