package Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    // 1 - First we save the connection state
    public static Connection objConnection = null;
    public static Connection openConnection() {

        try {
            // Connection data
            String url = "jdbc:mysql://localhost:3306/bookshop";
            String user = "root";
            String password = "Rlwl2023*";

            objConnection = DriverManager.getConnection(url, user, password);
            System.out.println("Perfectly connected");
        } catch (SQLException e) {
            System.out.println("Error connection: " + e.getMessage());
        }

        return objConnection;
    }
    public static void closeConnection() {

        try {
            if (objConnection != null){
                objConnection.close();
                System.out.println("Connection correctly closed");
            }
        } catch (SQLException e) {
            System.out.println("Error to finish the connection: " + e.getMessage());
        }

    }

}
