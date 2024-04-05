package controller;

import entity.Pasajero;
import entity.Vuelo;
import entity.VueloConAvion;
import model.ModelPasajero;
import model.ModelVuelo;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ControllerVuelo {
    public static void crearVuelo(){
        ModelVuelo objModelVuelo = new ModelVuelo();
        Vuelo objVuelo = new Vuelo();

        String destino = JOptionPane.showInputDialog("Ingresa el destino del vuelo");
        int id_avion = Integer.parseInt(JOptionPane.showInputDialog(ControllerAvion.listarAvionesString() + "\nIngresa el id del avion establecido para el viaje"));


        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                String fecha_salida = JOptionPane.showInputDialog("Ingresa la fecha de salida");
                LocalDate fecha = LocalDate.parse(fecha_salida, formatterDate);
                objVuelo.setFecha_salida(fecha);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error en patron, recuerda el formato (yyyy-MM-dd)");
                return;
            };

        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        try {
            String hora_salida = JOptionPane.showInputDialog("Ingresa la hora de salida");
            LocalTime time = LocalTime.parse(hora_salida, formatterTime);
            objVuelo.setHora_salida(time);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error en patron, recuerda el formato (HH:mm:ss)");
            return;
        }

        objVuelo.setDestino(destino);
        objVuelo.setId_avion(id_avion);


        Vuelo vuelo = (Vuelo) objModelVuelo.create(objVuelo);

        if (vuelo != null){
            JOptionPane.showMessageDialog(null, "El usuario se ha creado: \n" + vuelo);
        }

    }
    public static void listarVuelos(){
        ModelVuelo objModelVuelo = new ModelVuelo();
        String listaDeVuelos  = "Lista de vuelos\n";


        for (Object objVuelo: objModelVuelo.listar()){
            listaDeVuelos += (VueloConAvion) objVuelo + "\n";
        }
        JOptionPane.showMessageDialog(null, listaDeVuelos);
    }

}
