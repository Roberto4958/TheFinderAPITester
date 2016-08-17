/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import DataModel.Location;
import java.util.ArrayList;

/**
 * HistoryResponse is responsible for holding the http request status and hold a ArrayList of Location.
 * This class is used to communicate data from the backend API to the app.  
 * 
 * @author Roberto Aguilar
 */
public class HistoryResponse extends Response{

    public ArrayList<Location> UserLocations;
    
    public HistoryResponse(ArrayList<Location> l, String s){
        
        super(s);
        UserLocations = l;      
    }
}
