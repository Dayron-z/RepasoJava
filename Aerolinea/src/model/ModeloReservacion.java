package model;

import database.ConfigDB;
import entity.*;
import interfaces.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ModeloReservacion implements CRUD {
    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> listaDeReservaciones = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

    try {
        String sql = "SELECT reservacion.*, pasajero.*, vuelo.* " +
                "FROM reservacion " +
                "INNER JOIN pasajero ON pasajero.id_pasajero = reservacion.id_pasajero " +
                "INNER JOIN vuelo ON vuelo.id_vuelo = reservacion.id_vuelo";

        PreparedStatement objPrepare = objConnection.prepareStatement(sql);


       ResultSet objResult =  objPrepare.executeQuery();


        while (objResult.next()){
            Reservacion objReservacion = new Reservacion();
            objReservacion.setId_reservacion(objResult.getInt("id_reservacion"));
            objReservacion.setAsiento(objResult.getString("asiento"));

            Pasajero objPasajero = new Pasajero();
            objPasajero.setNombre_pasajero(objResult.getString("nombre"));
            objPasajero.setApellido_pasajero(objResult.getString("apellido"));
            objPasajero.setDocumento_identidad(objResult.getString("documento_identidad"));

            Vuelo objVuelo = new Vuelo();
            objVuelo.setId_vuelo(objResult.getInt("id_avion"));
            objVuelo.setDestino(objResult.getString("destino"));

            //Obtenemos fecha primero en string
            //Almacenamos en tipo de dato requerido y paraseamos el dato string
            //Luego podremos setear

            String fechaSalidaString = objResult.getString("fecha_salida");
            LocalDate fechaSalida = LocalDate.parse(fechaSalidaString);
            objVuelo.setFecha_salida(fechaSalida);


            String horaSalidaString = objResult.getString("hora_salida");
            LocalTime horaSalida = LocalTime.parse(horaSalidaString);
            objVuelo.setHora_salida(horaSalida);


            ReservacionPasajeroVuelo objRPA = new ReservacionPasajeroVuelo(objReservacion, objPasajero, objVuelo);

            listaDeReservaciones.add(objRPA);

        }



    } catch (Exception e) {
        System.out.println("Error en model reservacion :" + e.getMessage());
    }
        ConfigDB.closeConnection();
        return listaDeReservaciones;
    }
    @Override
    public Object create(Object obj) {
        Reservacion objReservacion = (Reservacion) obj;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "INSERT INTO reservacion (id_pasajero, id_vuelo, fecha_reservacion, asiento ) VALUES (?, ?, ?, ?)";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setInt(1, objReservacion.getId_pasajero());
            objPrepare.setInt(2, objReservacion.getId_vuelo());


            LocalDateTime fecha_reservacion = objReservacion.getFechaReservacion();
            java.sql.Timestamp fecha_reservacion_sql = java.sql.Timestamp.valueOf(fecha_reservacion);
            objPrepare.setTimestamp(3, fecha_reservacion_sql);
            objPrepare.setString(4, objReservacion.getAsiento());

            int filasAfectadas = objPrepare.executeUpdate();

            if (filasAfectadas > 0) {
                ResultSet objResult = objPrepare.getGeneratedKeys();
                if (objResult.next()) {
                    objReservacion.setId_reservacion(objResult.getInt(1));
                }
            } else {
                // Manejar el caso en el que no se insertó ninguna fila
                System.out.println("Error al insertar la reserva: no se insertaron filas");
                return null;
            }



            ResultSet objResult = objPrepare.getGeneratedKeys();

            if (objResult.next()){
                objReservacion.setId_reservacion(objResult.getInt(1));
            }


        }catch (SQLException e) {
            System.out.println("Error al insertar el vuelo: " + e.getMessage());
            return null;
        }

        ConfigDB.closeConnection();
        return objReservacion;
    }
    @Override
    public boolean update(Object obj) {
        Reservacion objReservacion = (Reservacion) obj;
        Connection objConexion = ConfigDB.openConnection();
        boolean isUpdate = false;

        try {
            String sql = "UPDATE reservacion SET id_pasajero = ?, id_vuelo = ?, fecha_reservacion = ?, asiento = ?  WHERE id_reservacion = ?;";

            PreparedStatement objPrepare = objConexion.prepareStatement(sql);

            objPrepare.setInt(1, objReservacion.getId_pasajero());
            objPrepare.setInt(2, objReservacion.getId_vuelo());


            LocalDateTime fecha_reservacion = objReservacion.getFechaReservacion();
            java.sql.Timestamp fecha_reservacion_sql = java.sql.Timestamp.valueOf(fecha_reservacion);
            objPrepare.setTimestamp(3, fecha_reservacion_sql);

            objPrepare.setString(4, objReservacion.getAsiento());


            objPrepare.setInt(5, objReservacion.getId_reservacion());


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
        Reservacion objReservacion;
        ReservacionPasajeroVuelo RPA = new ReservacionPasajeroVuelo();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT reservacion.*, pasajero.*, vuelo.* " +
                    "FROM reservacion " +
                    "INNER JOIN pasajero ON pasajero.id_pasajero = reservacion.id_pasajero " +
                    "INNER JOIN vuelo ON vuelo.id_vuelo = reservacion.id_vuelo " +
                    "WHERE id_reservacion = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id);



            ResultSet objResult =  objPrepare.executeQuery();

            if (objResult.next()){
                objReservacion = new Reservacion();
                objReservacion.setId_reservacion(objResult.getInt("id_reservacion"));
                objReservacion.setAsiento(objResult.getString("asiento"));
                objReservacion.setId_pasajero(objResult.getInt("id_pasajero"));
                objReservacion.setId_vuelo(objResult.getInt("id_vuelo"));


                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String fechaReservaString = objResult.getString("fecha_reservacion");
                LocalDateTime fechaReserva = LocalDateTime.parse(fechaReservaString, formatter);
                objReservacion.setFechaReservacion(fechaReserva);





                Pasajero objPasajero = new Pasajero();
                objPasajero.setNombre_pasajero(objResult.getString("nombre"));
                objPasajero.setApellido_pasajero(objResult.getString("apellido"));
                objPasajero.setDocumento_identidad(objResult.getString("documento_identidad"));

                Vuelo objVuelo = new Vuelo();
                objVuelo.setDestino(objResult.getString("destino"));

                //Obtenemos fecha primero en string
                //Almacenamos en tipo de dato requerido y paraseamos el dato string
                //Luego podremos setear

                String fechaSalidaString = objResult.getString("fecha_salida");
                LocalDate fechaSalida = LocalDate.parse(fechaSalidaString);
                objVuelo.setFecha_salida(fechaSalida);


                String horaSalidaString = objResult.getString("hora_salida");
                LocalTime horaSalida = LocalTime.parse(horaSalidaString);
                objVuelo.setHora_salida(horaSalida);


                 RPA = new ReservacionPasajeroVuelo(objReservacion, objPasajero, objVuelo);

            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return RPA;
    }
    @Override
    public boolean delete(Object obj) {
        boolean isDeleted = false;

        Reservacion objReservacion = (Reservacion) obj;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "DELETE FROM reservacion WHERE id_reservacion = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objReservacion.getId_reservacion());

            int filasAfectadas = objPrepare.executeUpdate();
            System.out.println(filasAfectadas);

            if (filasAfectadas > 0){
                isDeleted = true;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }


        return isDeleted;
    }




}
