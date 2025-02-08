package dams;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            //Registering a JDBC driver 
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creating connection string
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/dams","root","m@Nu_2722");
                        
            //Statement creation
            s = c.createStatement();
        }catch(Exception e){
            
        }
    }

    void add(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
