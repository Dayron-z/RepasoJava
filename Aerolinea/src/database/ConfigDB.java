package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    public static Connection objConnection = null;
    public static Connection openConnection(){
        try {
            String url = "jdbc:mysql://bvdfs2z523gvr9vvyshl-mysql.services.clever-cloud.com/bvdfs2z523gvr9vvyshl";
            String user = "uc6vf3scahaiyyjm";
            String password = "TbzOu8iRmU85Rbt19sUw";

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
