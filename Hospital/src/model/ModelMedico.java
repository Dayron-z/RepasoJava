package model;

import database.ConfigDB;
import entity.Medico;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelMedico implements CRUD {
    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> listaMedicos = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM medico";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Medico objMedico = new Medico();
                objMedico.setId(objResult.getInt("id_medico"));
                objMedico.setId_especialidad(objResult.getInt("id_especialidad"));
                objMedico.setNombre(objResult.getString("nombre"));
                objMedico.setApellido(objResult.getString("apellido"));

                listaMedicos.add(objMedico);
            }



        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"
                    + e.getMessage());
        }


        return listaMedicos;
    }
    @Override
    public Object create(Object obj) {
        Medico objMedico = (Medico) obj;
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "INSERT INTO medico (nombre, apellidos, id_especialidad) VALUES (?, ?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objMedico.getNombre());
            objPrepare.setString(2, objMedico.getApellido());
            objPrepare.setInt(3, objMedico.getId_especialidad());

            objPrepare.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"
                    + e.getMessage());
            System.out.println(e.getMessage());
        }

        return objMedico;
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
