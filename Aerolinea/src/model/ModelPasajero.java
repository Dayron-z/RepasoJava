package model;

import database.ConfigDB;

import entity.Avion;
import entity.Pasajero;
import interfaces.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelPasajero implements CRUD {
    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> listaDePasajeros = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM pasajero";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult =  objPrepare.executeQuery();

            while (objResult.next()){
                Pasajero objPasajero = new Pasajero();
                objPasajero.setId(objResult.getInt("id_pasajero"));
                objPasajero.setNombre_pasajero(objResult.getString("nombre"));
                objPasajero.setApellido_pasajero(objResult.getString("apellido"));
                objPasajero.setDocumento_identidad(objResult.getString("documento_identidad"));


                listaDePasajeros.add(objPasajero);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listaDePasajeros;
    }
    @Override
    public Object create(Object obj) {
        Pasajero objPasajero = (Pasajero) obj;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "INSERT INTO pasajero (nombre, apellido, documento_identidad) VALUES (?, ?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objPasajero.getNombre_pasajero());
            objPrepare.setString(2, objPasajero.getApellido_pasajero());
            objPrepare.setString(3, objPasajero.getDocumento_identidad());


            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            if (objResult.next()){
                objPasajero.setId(objResult.getInt(1));
            }


        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());

        }
        ConfigDB.closeConnection();

        return null;
    }
    @Override
    public boolean update(Object obj) {
        Pasajero objPasajero = (Pasajero) obj;
        Connection objConexion = ConfigDB.openConnection();
        boolean isUpdate = false;

        try {
            String sql = "UPDATE pasajero SET nombre = ?, apellido = ?, documento_identidad = ? WHERE id_pasajero = ?;";
            PreparedStatement objPrepare =  objConexion.prepareStatement(sql);

            objPrepare.setString(1, objPasajero.getNombre_pasajero());
            objPrepare.setString(2, objPasajero.getApellido_pasajero());
            objPrepare.setString(3, objPasajero.getDocumento_identidad());
            objPrepare.setInt(4,objPasajero.getId());

            int filasAfectadas =  objPrepare.executeUpdate();

            if (filasAfectadas > 0){
                isUpdate = true;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return isUpdate;
    }
    @Override
    public boolean delete(Object obj) {
        boolean isDeleted = false;

        Pasajero objPasajero = (Pasajero) obj;
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "DELETE FROM pasajero WHERE id_pasajero = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objPasajero.getId());

            int filasAfectadas = objPrepare.executeUpdate();

            if (filasAfectadas > 0){
                isDeleted = true;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }


        return isDeleted;

    }

    public Object findByID(int id){
        Pasajero objPasajero = new Pasajero();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM pasajero where id_pasajero = ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, id);

            ResultSet objResult =  objPrepare.executeQuery();

            while (objResult.next()){
                objPasajero.setId(objResult.getInt("id_avion"));
                objPasajero.setNombre_pasajero(objResult.getString("nombre"));
                objPasajero.setApellido_pasajero(objResult.getString("apellido"));
                objPasajero.setDocumento_identidad(objResult.getString("documento_identidad"));

            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objPasajero;
    }



}
