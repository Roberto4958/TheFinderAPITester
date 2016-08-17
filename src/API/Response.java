/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

/**
 * Response is responsible for holding the http request status.
 * This class is used to communicate data from the backend API to the app.
 *
 * @author Roberto Aguilar
 */
public class Response {
    
    public String status;

    public Response(String s){
        status = s;
    }
}
