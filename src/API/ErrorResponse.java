/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

/**
 * ErrorResponse stores the error type, used to warn the frontend to avoid crashing the app.
 *
 * @author Roberto Aguilar
 */
public class ErrorResponse {
    public String errorType;
    
    public ErrorResponse(String error){
        errorType = error;
    }
}
