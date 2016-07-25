/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import DataModel.User;
import API.UserResponse;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cancola
 */
public class APIcomm {
    private String baseURL = "http://thefinder-1.s4c2qwepti.us-west-2.elasticbeanstalk.com/webresources";
        
    
    public User LogIn(String userName, String password){
        String URL = baseURL + "/logIn/";
        String response = executeURL("POST", URL+userName+"/"+password);
        
        Gson gson =  new Gson();
        UserResponse r = gson.fromJson(response, UserResponse.class);
        
        if (r.status.equals("OK"))
        {
            return r.results;
        }
        else if (r.status.equals("ERROR"))
        {
            return null;
        }
        else if (r.status.equals("xxxxx"))
        {
            return null;
        }
        else 
        {
            return null;
        }
    }
    
    private String executeURL(String RequestType, String myurl) {
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
            return null;
        } 
        catch (ProtocolException ex) {
            Logger.getLogger(APIcomm.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
        catch (IOException ex) {
            Logger.getLogger(APIcomm.class.getName()).log(Level.SEVERE, null, ex);
            return null;
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
