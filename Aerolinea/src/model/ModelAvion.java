package model;

import database.ConfigDB;
import entity.Avion;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelAvion implements CRUD {

    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> listaDeAviones = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM avion";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult =  objPrepare.executeQuery();

            while (objResult.next()){
                Avion objAvion = new Avion();
                objAvion.setId(objResult.getInt("id_avion"));
                objAvion.setCapacidad(objResult.getInt("capacidad"));
                objAvion.setModelo(objResult.getString("modelo"));


                listaDeAviones.add(objAvion);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listaDeAviones;
    }

    @Override
    public Object create(Object obj) {
        Avion objAvion = (Avion) obj;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "INSERT INTO avion (modelo, capacidad) VALUES (?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objAvion.getModelo());
            objPrepare.setInt(2, objAvion.getCapacidad());

            objPrepare.execute();

        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());

        }
        ConfigDB.closeConnection();
        return objAvion;
    }

    @Override
    public boolean update(Object obj) {
        Avion objAvion = (Avion) obj;
        Connection objConexion = ConfigDB.openConnection();
        boolean isUpdate = false;

        try {
            String sql = "UPDATE avion SET modelo = ?, capacidad = ? WHERE id_avion = ?;";
            PreparedStatement objPrepare =  objConexion.prepareStatement(sql);

            objPrepare.setString(1, objAvion.getModelo());
            objPrepare.setInt(2, objAvion.getCapacidad());
            objPrepare.setInt(3,objAvion.getId());

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

        Avion objAvion = (Avion) obj;
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "DELETE FROM avion WHERE id_avion = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objAvion.getId());

            int filasAfectadas = objPrepare.executeUpdate();

            if (filasAfectadas > 0){
                isDeleted = true;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }


        return isDeleted;



    }
}
