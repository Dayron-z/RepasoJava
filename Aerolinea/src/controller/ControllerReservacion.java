package controller;

import entity.Avion;
import entity.Reservacion;
import entity.ReservacionPasajeroAvion;
import entity.VueloConAvion;
import model.ModeloReservacion;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.regex.Pattern;

public class ControllerReservacion {
    public static void crearReservacion(){
        ModeloReservacion objModelReservacion = new ModeloReservacion();
        Reservacion objReservacion =  new Reservacion();
        ReservacionPasajeroAvion objRPA = new ReservacionPasajeroAvion();
        Avion objAvion = new Avion();
        VueloConAvion objVueloConAvion = new VueloConAvion();





        int id_pasajero = Integer.parseInt(JOptionPane.showInputDialog(ControllerReservacion.listarReservacionString() + "\n Ingrese el pasajero con quien está asociada la reservacion "));
        int id_vuelo = Integer.parseInt(JOptionPane.showInputDialog(ControllerReservacion.listarReservacionString() + "\n Ingrese el vuelo con quien está asociada la reservacion"));



        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            String fecha_de_reservacion =JOptionPane.showInputDialog("Ingresa la fecha de reservacion (yyyy-MM-dd)");
            LocalDateTime fecha = LocalDateTime.parse(fecha_de_reservacion, formatterDate);
            objReservacion.setFechaReservacion(fecha);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error en el formato de la hora, recuerda que debes usar el formato (yyyy-MM-dd)" + e.getMessage());
            return;
        }








        int asientoNumero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de asiento que desea reservar"));


        String asiento = Integer.toString(asientoNumero);

        objReservacion.setId_pasajero(id_pasajero);
        objReservacion.setId_vuelo(id_vuelo);
        objReservacion.setAsiento(asiento);


        objModelReservacion.create(objModelReservacion);


/*        Implementa validaciones para asegurar que no se exceda la capacidad de los aviones con las
        reservaciones, y no se debe poder reservar un asiento que ya esta reservado.*/


    };



    public static void listarReservacion(){
        ModeloReservacion objReservacion = new ModeloReservacion();

        String listaDeReservas = "LISTA DE RESERVAS \n";

        for (Object reserva: objReservacion.listar()){
            listaDeReservas += (ReservacionPasajeroAvion) reserva + "\n";
        }

        JOptionPane.showMessageDialog(null, listaDeReservas);
    }
    public static String listarReservacionString(){
        ModeloReservacion objReservacion = new ModeloReservacion();

        String listaDeReservas = "LISTA DE RESERVAS \n";

        for (Object reserva: objReservacion.listar()){
            listaDeReservas += (ReservacionPasajeroAvion) reserva + "\n";
        }

        return  listaDeReservas;
    }
}
