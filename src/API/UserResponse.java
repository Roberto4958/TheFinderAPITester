/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import DataModel.User;

/**
 * UserResponse is responsible for holding the http request status and hold a User object.
 * This class is used to communicate data from the backend API to the app.
 *
 * @author Roberto Aguilar
 */
public class UserResponse extends Response{
    
    public User userInfo;

    public UserResponse(User u, String s){
        super(s);
        userInfo = u;
    }
}
