package model;

import database.ConfigDB;
import entity.Cita;
import entity.Paciente;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelCita  implements CRUD {
    @Override
    public ArrayList<Object> listar() {
        return null;
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
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }
}
