package MySQL;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    private static JDBC instancia = null;
    public static String ruta=null;
    private Connection con;

    private JDBC() {
        // LOAD THE DRIVER WE ARE GOING TO USE
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/proyectosolvd?user=root&password=root");

        } catch (ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "SQLException: " + ex.getMessage(), "Error", 0);
        }
    }

    public static JDBC getInstance() {
        if (instancia == null) {
            instancia = new JDBC();
        }
        return instancia;
    }

    public Statement getStatement() {
        Statement st = null;
        // creating a Statement object
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return st;
    }
}

