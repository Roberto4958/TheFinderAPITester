/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import DataModel.User;
import API.UserResponse;
import DataModel.Location;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cancola
 */
public class APIcomm {
    
    private String baseURL = "http://thefinder-1.s4c2qwepti.us-west-2.elasticbeanstalk.com/webresources";
    private String RequestType;     
    
    public User logIn(String userName, String password){
        String URL = baseURL + "/logIn/"+userName+"/"+password;
        RequestType = "POST";
        String response = executeURL(URL);
        Gson g =  new Gson();
        
        ErrorResponse e = g.fromJson(response, ErrorResponse.class);
        if(e.errorType != null)return null;
        
        UserResponse r = g.fromJson(response, UserResponse.class);
        
        if (r.status.equals("OK"))
        {
            return r.userInfo;
        }
        else if (r.status.equals("ERROR"))
        {
            return null;
        }
        else 
        {
            return null;
        }
    }
    
    public User createAccount(String userName, String password, String firstName, String lastName){
        
        String URL = baseURL+"/createAccount/"+userName+"/"+password+"/"+firstName+"/"+lastName;
        RequestType = "PUT";
        String response = executeURL(URL);
        
        Gson g =  new Gson();        
        ErrorResponse e = g.fromJson(response, ErrorResponse.class);
        if(e.errorType != null)return null;       
        
        UserResponse r = g.fromJson(response, UserResponse.class);
        if(r.status.equals("OK")){
            return r.userInfo;
        }
        else if(r.status.equals("ERROR")){
            return null;
        }
        else return null;
    }
    
    public void addLocation(int userID, double latitude, double longitude, String place, String auth){
        String URL = baseURL+"/addNewLocation/"+place+"/"+latitude+"/"+longitude+"/"+userID+"/"+auth;
        RequestType = "PUT";
        String response = executeURL(URL);
        Gson g = new Gson();
        
        ErrorResponse e = g.fromJson(response, ErrorResponse.class);
        if(e.errorType != null)return;
        
        Response r = g.fromJson(response, Response.class);
        if(r.status.equals("OK")){
            
        }
        else if(r.status.equals("TOKENCLEARED")){
            
        }
        else if(r.status.equals("ERROR")){
            
        }
        else{
           
        } 
    }
    
    public Location findLocation(int userID, String auth){
        String URL = baseURL+"/findLocation/"+userID+"/"+auth;
        RequestType= "GET";
        String response = executeURL(URL);
        Gson g = new Gson();
        ErrorResponse e = g.fromJson(response, ErrorResponse.class);
        if(e.errorType != null)return null;
        
        LocationResponse r = g.fromJson(response, LocationResponse.class);
        if(r.status.equals("OK")){
            return r.locationInfo;
        }
        else if(r.status.equals("TOKENCLEARED")){
            return null;
        }
        else if(r.status.equals("ERROR")){
            return null;
        }
        else{
           return null;
        }
    }
    
    public void deleteLocation(int userID, int locationID, String auth){
       String URL = baseURL+"/deleteLocation/"+userID+"/"+locationID+"/"+auth;
       RequestType = "DELETE";
       String response = executeURL(URL);
       Gson g = new Gson();
       ErrorResponse e = g.fromJson(response, ErrorResponse.class);
        if(e.errorType != null)return;
       Response r = g.fromJson(response, Response.class);
       if(r.status.equals("OK")){
        }
        else if(r.status.equals("TOKENCLEARED")){
        }
        else if(r.status.equals("ERROR")){
        }
        else{
        }
    }
    
    public ArrayList<Location> getHistory(int userID, String auth){
        String URL = baseURL+"/history/"+userID+"/"+auth;
        RequestType = "GET";
        String response = executeURL(URL); 
        Gson g = new Gson();
        ErrorResponse e = g.fromJson(response, ErrorResponse.class);
        if(e.errorType != null)return null;
        HistoryResponse r = g.fromJson(response, HistoryResponse.class);
        
        if(r.status.equals("OK")){
            return r.UserLocations;
        }
        else if(r.status.equals("TOKENCLEARED")){
            return null;
        }
        else if(r.status.equals("ERROR")){
            return null;
        }
        else{
            return null;
        }
    }
    
    public void logOut(int userID, String auth){
        String URL = baseURL+"/logOut/"+userID+"/"+auth;
        RequestType = "POST";
        String response = executeURL(URL);
        Gson g = new Gson();
        ErrorResponse e = g.fromJson(response, ErrorResponse.class);
        if(e.errorType != null)return;
        Response r = g.fromJson(response, Response.class);
        if(r.status.equals("OK")){
        }
        else if(r.status.equals("TOKENCLEARED")){
        }
        else if(r.status.equals("ERROR")){
        }
        else{
        }
    }
    
    private String executeURL(String myurl) {
        InputStream is = null;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod(RequestType);
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            is = conn.getInputStream();
            
            // Convert the InputStream into a string
            String contentAsString = readIS(is);
            return contentAsString;
        }  
        catch (MalformedURLException ex) {
            Logger.getLogger(APIcomm.class.getName()).log(Level.SEVERE, null, ex);
            Gson g = new Gson();
            String  r = g.toJson("malformed URL");
            //Todo: Toast error messege.
            return r;
        } 
        catch (ProtocolException ex) {
            Logger.getLogger(APIcomm.class.getName()).log(Level.SEVERE, null, ex);
            Gson g = new Gson();
            String  r = g.toJson("Protocal");
            //Todo: Toast error messege.
            return r;
        } 
        catch (IOException ex) {
            Logger.getLogger(APIcomm.class.getName()).log(Level.SEVERE, null, ex);
            Gson g = new Gson();
            String  r = g.toJson("IOException");
            //Todo: Toast error messege.
            return r;
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    Logger.getLogger(APIcomm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }  
    }
    
    private String readIS(InputStream stream) throws IOException, UnsupportedEncodingException {

        Scanner s = new Scanner(stream).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        return result;
    }
}
