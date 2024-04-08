package model;

import connection.ConfigDB;
import entity.TipoUsuario;
import entity.Usuario;
import repository.UserRepository;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

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

            objPrepare.executeUpdate();

            estadoRegistro = true;

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "error" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return estadoRegistro;
    }
    @Override
    public ArrayList<Usuario> loginUsuario(){
        ArrayList listaUsuarioRegistrados = new ArrayList<>();
        objConnection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM Usuarios";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult =  objPrepare.executeQuery();

            while (objResult.next()){
                Usuario objUsuario = new Usuario();
                objUsuario.setId(objResult.getString("id"));
                objUsuario.setNombre(objResult.getString("nombre"));
                objUsuario.setEmail(objResult.getString("email"));
                objUsuario.setContraseña(objResult.getString("contrasena"));
                objUsuario.setTipo(TipoUsuario.valueOf(objResult.getString("tipo").toUpperCase()));


                listaUsuarioRegistrados.add(objUsuario);

            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"  + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listaUsuarioRegistrados;
    }
    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        boolean estado = false;
        objConnection = ConfigDB.openConnection();

        try {
            String sql = "UPDATE Usuarios SET nombre = ?, email = ?, contrasena = ?, tipo = ?  WHERE id = ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);


            objPrepare.setString(1, usuario.getNombre());
            objPrepare.setString(2, usuario.getEmail());
            objPrepare.setString(3, usuario.getContraseña());
            objPrepare.setString(4, usuario.getTipo().toString());
            objPrepare.setString(5, usuario.getId());


            objPrepare.executeUpdate();

            estado = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "  + e.getMessage());
        }


        return estado;
    }




}
