package mysqldb;

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
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // db parameters
            String URL       = "jdbc:mysql://localhost:3306/movietheater";
            String USER      = "root";
            String PASSWORD  = "whereismykey";

            // create a connection to the database
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            Statement stmt=conn.createStatement();
    
            ResultSet rs=stmt.executeQuery("select * from employees"); 
            while(rs.next()){
                System.out.println("ID: " + rs.getInt(1)+"\nFull name : "+ rs.getString(2) 
                + " " + rs.getString(3) + "\nBirthdate : " + rs.getString(4) + "\n");
            }
            conn.close(); 
        } catch(SQLException e) {
           System.out.println(e.getMessage());
        } finally {
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}  