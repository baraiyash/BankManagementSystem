package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public Connection con;
    public Statement s;

    public Main() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/bms", "root", "1535");
            s = con.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("MySQL JDBC Driver not found.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection to database failed.");
        }
    }

    public static void main(String[] args) {
        // Test connection
        Main main = new Main();
        if (main.con != null) {
            System.out.println("Connected to database successfully!");
        } else {
            System.out.println("Failed to connect to database.");
        }
    }
}

