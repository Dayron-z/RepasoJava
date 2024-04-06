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
        Vuelo objVuelo = (Vuelo) obj;
        Connection objConexion = ConfigDB.openConnection();
        boolean isUpdate = false;



        try {
            String sql = "UPDATE vuelo SET destino = ?, fecha_salida = ?, hora_salida = ?, id_avion = ?  WHERE id_vuelo = ?;";
            PreparedStatement objPrepare =  objConexion.prepareStatement(sql);



            objPrepare.setString(1, objVuelo.getDestino());

            LocalDate fechaSalida = objVuelo.getFecha_salida();
            java.sql.Date fechaSalidaSQL = java.sql.Date.valueOf(fechaSalida);
            objPrepare.setDate(2, fechaSalidaSQL);


            LocalTime horaSalida = objVuelo.getHora_salida();
            java.sql.Time horaSalidaSQL = java.sql.Time.valueOf(horaSalida);
            objPrepare.setTime(3, horaSalidaSQL);

            objPrepare.setInt(4, objVuelo.getId_avion());
            objPrepare.setInt(5, objVuelo.getId_vuelo());

            int filasAfectadas =  objPrepare.executeUpdate();

            if (filasAfectadas > 0){
                isUpdate = true;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        ConfigDB.closeConnection();
        return isUpdate;
    }
    public Object findByID(int id){
        Vuelo objVuelo;
        VueloConAvion vueloConAvion = new VueloConAvion();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT vuelo.*, avion.modelo, avion.capacidad FROM vuelo INNER JOIN avion ON vuelo.id_avion = avion.id_avion WHERE vuelo.id_vuelo = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);


            objPrepare.setInt(1, id);

            ResultSet objResult =  objPrepare.executeQuery();

            if (objResult.next()){
                objVuelo = new Vuelo();
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

                vueloConAvion.setAvion(objAvion);
                vueloConAvion.setVuelo(objVuelo);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return vueloConAvion;
    }
    @Override
    public boolean delete(Object obj) {
        boolean isDeleted = false;

        Vuelo objVuelo = (Vuelo) obj;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "DELETE FROM vuelo WHERE id_vuelo = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objVuelo.getId_vuelo());

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
