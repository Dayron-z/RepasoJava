package connection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    public static Connection connection = null;

    public static Connection openConnection(){
        try {
            //Valida si el driver está instalado
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://bmvsmi0esoffitpzuopq-mysql.services.clever-cloud.com/bmvsmi0esoffitpzuopq";
            String user = "ugidzdymhgf3yzqp";
            String password = "ZfpptjTi9OHnPYy0m5Ln";

            //Le damos valor atributo que inicializamos como null.
            connection  = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Conectado exitosamente");

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
        return connection;
    }


    public static void closeConnection(){
        if (connection != null){
            try {
                connection.close();
                System.out.println("Conexion cerrada con exito");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            }

        }

    }


}
