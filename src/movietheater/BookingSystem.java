/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movietheater;
import java.sql.Connection;
import mysqldb.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import mysqldb.Database;
/**
 *
 * @author Quentin
 */
public class BookingSystem {
    
    public BookingSystem(){
        new Database();
    }
    
    public void startApp(){
        Database.getAllCustomers();
        Database.resetPassword(1, "wa c est chaud", false);
        Database.getAllCustomers();
        
        if(Database.isConnected()){
            Database.closeConnection();
        }
    }
    
    
    public static void main(String[] args){
        BookingSystem bs = new BookingSystem();
        bs.startApp();
    }
}
