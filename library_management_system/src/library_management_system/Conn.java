package library_management_system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///librarymanagementsystem", "root", "root");
            s=c.createStatement();

        } catch (ClassNotFoundException |SQLException e ) {
            e.printStackTrace();
        }
    }
        
}
