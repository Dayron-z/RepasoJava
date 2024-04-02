package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

        public static Connection objConnection = null;

        public static Connection openConnection(){
                try {
                        Class.forName("com.mysql.cj.jdbc.Driver");


                        String url = "jdbc:mysql://localhost:3306/hospital";
                        String user = "root";
                        String password = "Rlwl2023*";

                        objConnection = DriverManager.getConnection(url, user, password);
                        System.out.println("Conectado perfectamente");
                } catch (SQLException e) {
                        System.out.println("Error:" + e.getMessage());
                } catch (ClassNotFoundException e) {
                        System.out.println("Error:" + e.getMessage());
                }

            return objConnection;
        }


        public static void closeConnection(){
                try {
                 objConnection.close();
                        System.out.println("Conexión cerrada correctamente");
                }catch (SQLException e){
                        System.out.println("Error:" + e.getMessage());
                }
        }


}
