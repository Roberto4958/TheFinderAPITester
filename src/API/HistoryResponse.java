/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import DataModel.Location;
import java.util.ArrayList;

/**
 *
 * @author cancola
 */
public class HistoryResponse extends Response{

    public ArrayList<Location> result;

    public HistoryResponse(ArrayList<Location> l, String s){

        super(s);
        result = l;
    }
}
