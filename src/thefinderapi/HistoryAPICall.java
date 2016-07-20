/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thefinderapi;

import ResponseData.HistoryResponse;
import com.google.gson.Gson;
import java.io.IOException;

/**
 *
 * @author cancola
 */
public class HistoryAPICall {
    
    public HistoryAPICall(){
    }
    
    public HistoryResponse getResponse(int id, String auth)throws IOException{
        ServerConnection SC = new ServerConnection();
        String url = "http://thefinder-1.s4c2qwepti.us-west-2.elasticbeanstalk.com/webresources/history/";
        String response = SC.downloadUrl("GET", url+id+"/"+auth);
        
        if(response != null){
            Gson gson = new Gson();
            HistoryResponse r = gson.fromJson(response, HistoryResponse.class);
            return r;
        }
        else return null;
    }
}
