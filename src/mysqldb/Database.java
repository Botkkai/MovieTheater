package mysqldb;

import java.util.ArrayList;
import movietheater.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Quentin
 */
public class Database {
    /**
     * @param args the command line arguments
     */
    private static Connection conn = null;
    private static Database db = null;
    
    public Database(){
        connect();
    }
    
    public static boolean isConnected(){ //inutile je pense
        return (conn!=null);
    }
        
    public static void connect(){
        try {
            // db parameters
            String DB_NAME   = "movietheater";
            String URL       = "jdbc:mysql://localhost:3306/"+DB_NAME;
            String USER      = "root";
            String PASSWORD  = "whereismykey";

            // create a connection to the database
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Successfully connected to the DB.");
        } catch(SQLException e) {
           System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Customer> getAllCustomers(){
        ArrayList<Customer> allCustomers = new ArrayList<Customer>();
        try{
            String columns = "ID,name,surname,birthdate,address,email,password";
            ResultSet rs = db.query("select " + columns + " from customers");
            while(rs.next()){
                Customer cust = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                        
                allCustomers.add(cust);
            }
        }catch(SQLException e) {
           System.out.println(e.getMessage());
        }
        for(int i=0; i<allCustomers.size(); i++){
            System.out.println("ID: " + allCustomers.get(i).getId() + 
                    " Password: " + allCustomers.get(i).getPassword());
        }
        return allCustomers;
    }
    
    public static void resetPassword(int profileId, String newPassword, boolean isEmployee){
        String table = (isEmployee) ? "employees" : "customers";
        
        db.update("update "+table+" set password='" + newPassword + "' where ID=1");
        System.out.println("Password reseted for "+table+" n°" + profileId);
    }
    
    public static ResultSet query(String q){
        ResultSet rs = null;
        try{
            Statement stmt=conn.createStatement();
            rs=stmt.executeQuery(q);
        }catch(SQLException e) {
           System.out.println(e.getMessage());
        }finally{
            return rs;
        }
    }
    
    public static void update(String q){
        try{
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(q);
        }catch(SQLException e) {
           System.out.println(e.getMessage());
        }
    }
    
    public static void closeConnection(){
        try{
            if(conn != null){
                conn.close();
                conn = null;
                System.out.println("Successfully closed connection to the DB.");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}  