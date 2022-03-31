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
public class Employee extends Profile{
    int ID;
    double hourlyWage;
    int weeklyHours;
    
    public Employee(int ID, String name, String surname, String birthdate, String address, String email, String password,
            double hourlyWage, int weeklyHours){
        
        super(name, surname, birthdate, address, email, password);
        this.ID = ID;
        this.hourlyWage = hourlyWage;
        this.weeklyHours = weeklyHours;
    }
    
    @Override
    public void resetPassword(String newPassword){
        Database.resetPassword(ID, newPassword, true);
    }
}
