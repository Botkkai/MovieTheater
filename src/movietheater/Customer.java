/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movietheater;

import mysqldb.Database;

/**
 *
 * @author Quentin
 */
public class Customer extends Profile{
    private final int ID;
    
    public Customer(int ID, String name, String surname, String birthdate, 
            String address, String email, String password){
        
        super(name, surname, birthdate, address, email, password);
        this.ID = ID;
    }
    
    public int getId(){
        return ID;
    }
    
    @Override
    public void resetPassword(String newPassword){
        Database.resetPassword(ID, newPassword, false);
    }
}
