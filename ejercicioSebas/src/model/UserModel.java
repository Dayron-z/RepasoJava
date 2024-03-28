package model;

import connection.ConfigDB;
import entity.Usuario;
import repository.UserRepository;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserModel implements UserRepository {
    Connection objConnection;
    @Override
    public boolean registrarUsuario(Usuario usuario) {
        boolean estadoRegistro = false;
        objConnection = ConfigDB.openConnection();

        try {
            String sql = "INSERT INTO Usuarios (id, nombre, email, contrasena, tipo)" +
                    "VALUES (?, ?, ?, ?, ?);";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, usuario.getId());
            objPrepare.setString(2, usuario.getNombre());
            objPrepare.setString(3, usuario.getEmail());
            objPrepare.setString(4, usuario.getContraseña());
            objPrepare.setString(5, usuario.getTipo().name());

            objPrepare.executeQuery();

            estadoRegistro = true;

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "error" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return estadoRegistro;
    }

    @Override
    public boolean loginUsuario(Usuario usuario) {
        return false;
    }
}
