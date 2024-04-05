package model;

import database.ConfigDB;
import entity.Avion;
import entity.Vuelo;
import entity.VueloConAvion;
import interfaces.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ModelVuelo implements CRUD {
    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> listaDeVuelos = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT vuelo.*, avion.modelo, avion.capacidad FROM vuelo INNER JOIN avion ON vuelo.id_avion = avion.id_avion;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult =  objPrepare.executeQuery();

            while (objResult.next()){
                Vuelo objVuelo = new Vuelo();
                objVuelo.setId_vuelo(objResult.getInt("id_vuelo"));
                objVuelo.setDestino(objResult.getString("destino"));

                String fechaSalidaStr = objResult.getString("fecha_salida");
                LocalDate fechaSalida = LocalDate.parse(fechaSalidaStr);
                objVuelo.setFecha_salida(fechaSalida);

                String horaSalidaStr = objResult.getString("hora_salida");
                LocalTime horaSalida = LocalTime.parse(horaSalidaStr);
                objVuelo.setHora_salida(horaSalida);

                Avion objAvion = new Avion();
                objAvion.setModelo(objResult.getString("modelo"));
                objAvion.setCapacidad(objResult.getInt("capacidad"));

                VueloConAvion vueloConAvion = new VueloConAvion(objVuelo, objAvion);

                listaDeVuelos.add(vueloConAvion);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listaDeVuelos;
    }
    @Override
    public Object create(Object obj) {
        Vuelo objVuelo = (Vuelo) obj;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "INSERT INTO vuelo (destino, fecha_salida, hora_salida, id_avion ) VALUES (?, ?, ?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objVuelo.getDestino());

            LocalDate fechaSalida = objVuelo.getFecha_salida();
            java.sql.Date fechaSalidaSQL = java.sql.Date.valueOf(fechaSalida);
            objPrepare.setDate(2, fechaSalidaSQL);


            LocalTime horaSalida = objVuelo.getHora_salida();
            java.sql.Time horaSalidaSQL = java.sql.Time.valueOf(horaSalida);
            objPrepare.setTime(3, horaSalidaSQL);

            objPrepare.setInt(4, objVuelo.getId_avion());


            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            if (objResult.next()){
                objVuelo.setId_vuelo(objResult.getInt(1));
            }


        } catch (SQLException e) {
            System.out.println("Error al insertar el vuelo: " + e.getMessage());
            return null;
        }
        ConfigDB.closeConnection();
        return objVuelo;
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
