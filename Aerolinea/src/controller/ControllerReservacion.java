package controller;

import entity.*;
import model.ModelAvion;
import model.ModelVuelo;
import model.ModeloReservacion;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ControllerReservacion {
    public static void crearReservacion() {
        ModelVuelo objModelVuelo = new ModelVuelo();
        ModelAvion objModelAvion = new ModelAvion();
        ModeloReservacion objModelReservacion = new ModeloReservacion();
        Reservacion objReservacion = new Reservacion();
        int asientoNumero;
        int id_pasajero = Integer.parseInt(JOptionPane.showInputDialog(ControllerPasajero.listarPasajeroString() + "\n Ingrese el pasajero con quien está asociada la reservacion "));
        int id_vuelo = Integer.parseInt(JOptionPane.showInputDialog(ControllerVuelo.listarVuelosString() + "\n Ingrese el vuelo con quien está asociada la reservacion"));


        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            String fecha_de_reservacion = JOptionPane.showInputDialog("Ingresa la fecha de reservacion (yyyy-MM-dd)");
            LocalDate fecha = LocalDate.parse(fecha_de_reservacion, formatterDate);
            LocalDateTime fechaConHoraCero = fecha.atStartOfDay(); // Establece la hora y el minuto como cero
            objReservacion.setFechaReservacion(fechaConHoraCero);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de la fecha, recuerda que debes usar el formato (yyyy-MM-dd)");
            return;
        }

        try {
            asientoNumero = Integer.parseInt((JOptionPane.showInputDialog("Ingrese el numero de asiento que desea reservar")));
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un número entero válido.");
            return;
        }


// Después de la solicitud y conversión del número de asiento
        boolean asientoReservado = false;

        for (Object reserva : objModelReservacion.listar()) {
            ReservacionPasajeroVuelo reservaVuelo = (ReservacionPasajeroVuelo) reserva;
            if (asientoNumero == Integer.parseInt(reservaVuelo.getReservacion().getAsiento())) {
                JOptionPane.showMessageDialog(null, "El asiento ya se encuentra reservado");
                asientoReservado = true;
                break; // Salir del bucle si se encuentra una reserva con el mismo asiento
            }
        }


        VueloConAvion objVuelo = (VueloConAvion) objModelVuelo.findByID(id_vuelo);
        System.out.println(objVuelo);
        int id_avion = objVuelo.getVuelo().getId_avion();


// Verificar si el asiento excede la capacidad del avión o es inválido
        int capacidad = objModelAvion.obtenerCapacidadDeAsientos(id_avion);
        if (asientoNumero > capacidad) {
            System.out.println(capacidad);
            System.out.println(id_avion);
            JOptionPane.showMessageDialog(null, "El asiento no es válido. Capacidad de este avion: " + capacidad);
            return;
        }

        if (asientoNumero <= 0){
            JOptionPane.showMessageDialog(null, "No se acepta 0 ni numeros negativos ⚠");
            return;
        }


        if (asientoReservado) {
                return;
            } else {
                objReservacion.setAsiento(Integer.toString(asientoNumero));
            }

            objReservacion.setId_pasajero(id_pasajero);
            objReservacion.setId_vuelo(id_vuelo);
            Reservacion objReservacionString = (Reservacion) objModelReservacion.create(objReservacion);
            JOptionPane.showMessageDialog(null, "Reservación creada con exito: " + objReservacionString);
    };
    public static void listarReservacion(){
        ModeloReservacion objReservacion = new ModeloReservacion();

        String listaDeReservas = "LISTA DE RESERVAS \n";
        Pasajero objPasajero;

        for (Object reserva: objReservacion.listar()){
            listaDeReservas += (ReservacionPasajeroVuelo) reserva + "\n";
        }

        JOptionPane.showMessageDialog(null, listaDeReservas);
    }
    public static String listarReservacionString(){
        ModeloReservacion objReservacion = new ModeloReservacion();

        String listaDeReservas = "LISTA DE RESERVAS \n";

        for (Object reserva: objReservacion.listar()){
            listaDeReservas += (ReservacionPasajeroVuelo) reserva + "\n";
        }

        return  listaDeReservas;
    }
    public static void actualizarReservacion(){
        ModelVuelo objModelVuelo = new ModelVuelo();
        ModelAvion objModelAvion = new ModelAvion();
        ModeloReservacion objModelReservacion = new ModeloReservacion();
        Reservacion objReservacion = new Reservacion();
        int asientoNumero;


        int idReservacion =  Integer.parseInt(JOptionPane.showInputDialog(listarReservacionString() + "\n Ingrese el id de la reservacion que desea editar"));


/*        ReservacionPasajeroVuelo objReservacionEspecifica =  (ReservacionPasajeroVuelo) objModelReservacion.findByID(idReservacion);
        System.out.println(objReservacionEspecifica.getReservacion().getId_reservacion());*/

        ReservacionPasajeroVuelo objReservacionEspecifica = (ReservacionPasajeroVuelo) objModelReservacion.findByID(idReservacion);




        int id_pasajero = Integer.parseInt(JOptionPane.showInputDialog(ControllerPasajero.listarPasajeroString() + "\n Ingrese el pasajero con quien está asociada la reservacion", objReservacionEspecifica.getReservacion().getId_pasajero() ));

        int id_vuelo = Integer.parseInt(JOptionPane.showInputDialog(ControllerVuelo.listarVuelosString() + "\n Ingrese el vuelo con quien está asociada la reservacion", objReservacionEspecifica.getReservacion().getId_vuelo()));


        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            String fecha_de_reservacion = JOptionPane.showInputDialog("Ingresa la fecha de reservacion (yyyy-MM-dd)", objReservacionEspecifica.getReservacion().getFechaReservacion().toString().substring(0,  10));
            LocalDate fecha = LocalDate.parse(fecha_de_reservacion, formatterDate);
            LocalDateTime fechaConHoraCero = fecha.atStartOfDay(); // Establece la hora y el minuto como cero
            objReservacion.setFechaReservacion(fechaConHoraCero);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de la fecha, recuerda que debes usar el formato (yyyy-MM-dd)");
            return;
        }

        try {
            asientoNumero = Integer.parseInt((JOptionPane.showInputDialog("Ingrese el numero de asiento que desea reservar", objReservacionEspecifica.getReservacion().getAsiento())));
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un número entero válido.");
            return;
        }


// Después de la solicitud y conversión del número de asiento
        boolean asientoReservado = false;

        for (Object reserva : objModelReservacion.listar()) {
            ReservacionPasajeroVuelo reservaVuelo = (ReservacionPasajeroVuelo) reserva;
            if (asientoNumero == Integer.parseInt(reservaVuelo.getReservacion().getAsiento())) {
                JOptionPane.showMessageDialog(null, "El asiento ya se encuentra reservado");
                asientoReservado = true;
                break; // Salir del bucle si se encuentra una reserva con el mismo asiento
            }
        }


        VueloConAvion objVuelo = (VueloConAvion) objModelVuelo.findByID(id_vuelo);
        System.out.println(objVuelo);
        int id_avion = objVuelo.getVuelo().getId_avion();


// Verificar si el asiento excede la capacidad del avión o es inválido
        int capacidad = objModelAvion.obtenerCapacidadDeAsientos(id_avion);
        if (asientoNumero > capacidad) {
            System.out.println(capacidad);
            System.out.println(id_avion);
            JOptionPane.showMessageDialog(null, "El asiento no es válido. Capacidad de este avion: " + capacidad);
            return;
        }

        if (asientoNumero <= 0){
            JOptionPane.showMessageDialog(null, "No se acepta 0 ni numeros negativos ⚠");
            return;
        }


        if (asientoReservado) {
            return;
        } else {
            objReservacion.setAsiento(Integer.toString(asientoNumero));
        }

        objReservacion.setId_reservacion(idReservacion);
        objReservacion.setId_pasajero(id_pasajero);
        objReservacion.setId_vuelo(id_vuelo);
        Boolean objReservacionString = (boolean) objModelReservacion.update(objReservacion);
        JOptionPane.showMessageDialog(null, "Reservación actualizada con exito");

    }
    public static void eliminarReservacion(){
        ModeloReservacion objModelReservacion = new ModeloReservacion();
        Reservacion objReservacion = new Reservacion();

        int id = Integer.parseInt(JOptionPane.showInputDialog(listarReservacionString() + "\n Ingrese el id del avion que desea eliminar"));

        objReservacion.setId_reservacion(id);


        boolean validacion = objModelReservacion.delete(objReservacion);;

        if (validacion){
            JOptionPane.showMessageDialog(null, "Reservacion  eliminada con éxito" );
        }

    }

}
