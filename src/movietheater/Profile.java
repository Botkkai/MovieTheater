/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movietheater;

/**
 *
 * @author Quentin
 */
public abstract class Profile {
    private String name;
    private String surname;
    private String birthdate;
    private String address;
    private String email;
    private String password;

    public Profile(String name, String surname, String birthdate, String address, String email, String password){
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getBirthdate(){
        return birthdate;
    }

    public String getAddress(){
        return address;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setBirthdate(String birthdate){
        this.birthdate = birthdate;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }
    
    public abstract void resetPassword(String newPassword);
}