/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

/**
 *
 * @author cancola
 */
public class ErrorResponse {
    public String errorType;
    
    public ErrorResponse(String error){
        errorType = error;
    }
}