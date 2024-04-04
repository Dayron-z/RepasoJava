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
            String sql = "SELECT * FROM cita";
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
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }
}
