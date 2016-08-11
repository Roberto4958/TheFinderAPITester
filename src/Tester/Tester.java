/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import DataModel.User;
import API.APIcomm;
import DataModel.Location;
import java.util.ArrayList;


/**
 *
 * @author cancola
 */
public class Tester {
    
    public static void main(String args[]){
       
        APIcomm myComm = new APIcomm();
        User user = null ;
        Location location;
        
        user = myComm.createAccount("user320", "pass", "Bob", "Smith");
        try{
            System.out.println("Testing create account. New user Name is "+user.userName+"\n");
        }
        catch(Exception e){
            System.out.println("That userName is alrady taken, please use a deffrent userName");
        }
        
        user = myComm.logIn("user1", "pass1");
        System.out.println("Testing user login for user1. Name is: " + user.firstName + " " + user.lastName+"\n");
        
        myComm.addLocation(user.ID, 24521, 5135135, "RandomLocation2", user.authToken);
        location = myComm.findLocation(user.ID, user.authToken);
        System.out.println("Testing addLocation, and findLocation. \n\tAdded: RandomLocation2\n\tFindLocation resturns: "+location.place+"\n");
       
        myComm.deleteLocation(user.ID, location.locationID, user.authToken);
        ArrayList<Location> collection = myComm.getHistory(user.ID, user.authToken);
        System.out.println("Testing delete, and history. Deleted RandomLocation2, and called get history on user1:");
        for(int i=0;i < collection.size();i++){
            System.out.println("\t"+collection.get(i).place);
        }
        
        myComm.logOut(user.ID, user.authToken);
        System.out.println("\nTesting Log out. Loged out succesfully");
    }
}
