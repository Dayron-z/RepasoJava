package controller;

import entity.*;
import model.ModeloReservacion;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ControllerReservacion {
    public static void crearReservacion() {
        ModeloReservacion objModelReservacion = new ModeloReservacion();
        Reservacion objReservacion = new Reservacion();
        /*        String asientoReservado = "";*/
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
            }};


            if (asientoReservado) {
                return; // Si el asiento está reservado, terminar la función
            } else {
                objReservacion.setAsiento(Integer.toString(asientoNumero));
            }


            objReservacion.setId_pasajero(id_pasajero);
            objReservacion.setId_vuelo(id_vuelo);
            Reservacion objReservacionString = (Reservacion) objModelReservacion.create(objReservacion);
            JOptionPane.showMessageDialog(null, "Reservación creada con exito" + objReservacionString);


/*        Implementa validaciones para asegurar que no se exceda la capacidad de los aviones con las
        reservaciones, y no se debe poder reservar un asiento que ya esta reservado.*/


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

}
