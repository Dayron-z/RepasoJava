package model;

import database.ConfigDB;
import entity.Cita;
import entity.Paciente;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelCita  implements CRUD {
    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> listaDeCitas  = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM cita;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult =  objPrepare.executeQuery();

            while (objResult.next()){
                Cita objCita = new Cita();
                objCita.setId(objResult.getInt("id_cita"));
                objCita.setId_paciente(objResult.getInt("id_paciente"));
                objCita.setId_medico(objResult.getInt("id_medico"));
                objCita.setFecha_cita(objResult.getString("fecha_cita")  );
                objCita.setHora_cita(objResult.getString("hora_cita")  );
                objCita.setMotivo(objResult.getString("motivo"));

                listaDeCitas.add(objCita);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listaDeCitas;

    }
    @Override
    public Object create(Object obj) {
        Cita objCita = (Cita) obj;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "INSERT INTO cita (id_paciente, id_medico, fecha_cita, hora_cita, motivo) VALUES (?,?,?,?,?);";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, objCita.getId_paciente());
            objPrepare.setInt(2, objCita.getId_medico());
            objPrepare.setString(3, objCita.getFecha_cita());
            objPrepare.setString(4, objCita.getHora_cita());
            objPrepare.setString(5, objCita.getMotivo());


            objPrepare.execute();

        } catch (SQLException e) {
            System.out.println("Error en model "
                    + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objCita;
    }
    @Override
    public boolean update(Object obj) {
        Cita objCita = (Cita) obj;
        Connection objConexion = ConfigDB.openConnection();
        boolean isUpdate = false;

        try {
            String sql = "UPDATE cita SET id_paciente = ?, id_medico = ?, fecha_cita = ?, hora_cita  = ?, motivo = ? WHERE id_cita = ?;";

            PreparedStatement objPrepare =  objConexion.prepareStatement(sql);

            objPrepare.setInt(1, objCita.getId_paciente());
            objPrepare.setInt(2,objCita.getId_medico());
            objPrepare.setString(3,objCita.getFecha_cita());
            System.out.println(objCita.getHora_cita());
            objPrepare.setString(4,objCita.getHora_cita());
            objPrepare.setString(5,objCita.getMotivo());
            objPrepare.setInt(6,objCita.getId());


            System.out.println(objPrepare);

            int filasAfectadas =  objPrepare.executeUpdate();

            if (filasAfectadas > 0){
                System.out.println(filasAfectadas);
                isUpdate = true;
                JOptionPane.showMessageDialog(null,"Actualizado con exito" );
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ConfigDB.closeConnection();
        return isUpdate;
    }
    @Override
    public boolean delete(Object obj) {
        boolean isDeleted = false;
        Cita objCita = (Cita) obj;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "DELETE FROM cita WHERE id_cita = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objCita.getId());


            int filasAfectadas = objPrepare.executeUpdate();

            if (filasAfectadas > 0){
                JOptionPane.showMessageDialog(null, "Cita eliminada satisfactorimente");
                isDeleted = true;
            }

        } catch (SQLException e) {
            System.out.println("Error en model" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return isDeleted;
    }
}
