/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

import java.io.Serializable;

/**
 *
 * @author JD
 */
public class DBException extends RuntimeException implements Serializable{
    public DBException(String msg){
        super(msg);
    }
    
}
