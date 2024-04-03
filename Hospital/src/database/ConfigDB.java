package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
        public static Connection objConnection = null;
        public static Connection openConnection(){
                try {
                        String url = "jdbc:mysql://bhqpwbvnqqf0uk9rxq97-mysql.services.clever-cloud.com/bhqpwbvnqqf0uk9rxq97";
                        String user = "ucmtcrt6jodmrhs4";
                        String password = "PusXeVJo1AIaP3HR9oQC";

                        objConnection = DriverManager.getConnection(url, user, password);
                        System.out.println("Conectado perfectamente");
                } catch (SQLException e) {
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
