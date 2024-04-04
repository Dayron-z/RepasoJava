package model;

import database.ConfigDB;
import entity.Especialidad;
import entity.Paciente;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelPaciente implements CRUD {
    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> listaDePacientes  = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM paciente ";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult =  objPrepare.executeQuery();

            while (objResult.next()){
                Paciente objPaciente = new Paciente();
                objPaciente.setId(objResult.getInt("id_paciente"));
                objPaciente.setNombre(objResult.getString("nombre"));
                objPaciente.setApellidos(objResult.getString("apellidos"));
                objPaciente.setFecha_nacimiento(objResult.getString("fecha_nacimiento"));
                objPaciente.setDocumento_identidad(objResult.getString("documento_identidad"));

                listaDePacientes.add(objPaciente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listaDePacientes;
    }
    @Override
    public Object create(Object obj) {
        Paciente objPaciente = (Paciente) obj;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "INSERT INTO paciente (nombre, apellidos,fecha_nacimiento, documento_identidad) VALUES (?,?,?,?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objPaciente.getNombre());
            objPrepare.setString(2, objPaciente.getApellidos());
            objPrepare.setString(3, objPaciente.getFecha_nacimiento());
            objPrepare.setString(4, objPaciente.getDocumento_identidad());


            objPrepare.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"
                    + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objPaciente;

    }
    @Override
    public boolean update(Object obj) {
        Paciente objPaciente = (Paciente) obj;
        Connection objConexion = ConfigDB.openConnection();
        boolean isUpdate = false;

        try {
            String sql = "UPDATE paciente SET nombre = ?, apellidos = ?, fecha_nacimiento = ?, documento_identidad = ? WHERE id_paciente = ?;";
            PreparedStatement objPrepare =  objConexion.prepareStatement(sql);

            objPrepare.setString(1, objPaciente.getNombre());
            objPrepare.setString(2, objPaciente.getApellidos());
            objPrepare.setString(3, objPaciente.getFecha_nacimiento());
            objPrepare.setString(4, objPaciente.getDocumento_identidad());
            objPrepare.setInt(5, objPaciente.getId());



            int filasAfectadas =  objPrepare.executeUpdate();

            if (filasAfectadas > 0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null,"Actualizado con exito" );
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return isUpdate;
    }
    @Override
    public boolean delete(Object obj) {

        boolean isDeleted = false;

        Paciente objPaciente = (Paciente) obj;
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "DELETE FROM paciente WHERE id_paciente = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objPaciente.getId());
            int filasAfectadas = objPrepare.executeUpdate();

            if (filasAfectadas > 0){
                JOptionPane.showMessageDialog(null, "Especialidad eliminada satisfactorimente");
                isDeleted = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return isDeleted;
    }

    public Object buscarPacientePorCedula(String cedula){
        Connection objConnection = ConfigDB.openConnection();
        Paciente objPaciente = new Paciente();
        try {
            String sql = "SELECT * FROM paciente where documento_identidad = ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, cedula);

            ResultSet objResult =  objPrepare.executeQuery();

            if (objResult.next()){
                objPaciente.setId(objResult.getInt("id_paciente"));
                objPaciente.setNombre(objResult.getString("nombre"));
                objPaciente.setApellidos(objResult.getString("apellidos"));
                objPaciente.setFecha_nacimiento(objResult.getString("fecha_nacimiento"));
                objPaciente.setDocumento_identidad(objResult.getString("documento_identidad"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }


        return objPaciente;
    }



}
