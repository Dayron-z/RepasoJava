package model;

import database.ConfigDB;
import entity.Especialidad;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelEspecialidad implements CRUD {

    @Override
    public ArrayList<Object> listar() {
        return null;
    }





    @Override
    public Object create(Object obj) {
        Especialidad objEspecialidad = (Especialidad) obj;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "INSERT INTO especialidad (nombre, descripcion) VALUES (?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objEspecialidad.getNombre());
            objPrepare.setString(2, objEspecialidad.getDescripcion());

            objPrepare.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" +  e.getMessage());
        }


        return false;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }
}
