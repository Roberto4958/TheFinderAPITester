/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import DataModel.User;
import ResponseData.HistoryResponse;
import ResponseData.LocationResponse;
import ResponseData.Response;
import ResponseData.UserResponse;
import java.io.IOException;
import thefinderapi.AddLocationAPICall;
import thefinderapi.CreateAccountAPICall;
import thefinderapi.FindLocationAPICall;
import thefinderapi.HistoryAPICall;
import thefinderapi.LogInAPICall;
import thefinderapi.LogOutAPICall;
import thefinderapi.RemoveAPICall;
import thefinderapi.ServerConnection;

/**
 *
 * @author cancola
 */
public class Tester {
    
    public static void main(String args[]) throws IOException{
       
        FindLocationAPICall SC = new  FindLocationAPICall();
        LocationResponse result  = SC.getResponse(1, "g6m5d7318a3mn3fh47p62njxd9sfvm");
        System.out.println(result.status);
    }
}
