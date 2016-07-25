/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import DataModel.User;
import API.APIcomm;


/**
 *
 * @author cancola
 */
public class Tester {
    
    public static void main(String args[]){
       
        APIcomm myComm = new APIcomm();
        User user = myComm.LogIn("user1", "pass1");
        System.out.println(user.firstName + " " + user.lastName);
       
    }
}
