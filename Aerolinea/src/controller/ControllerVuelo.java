package controller;

import entity.Avion;
import entity.Pasajero;
import entity.Vuelo;
import entity.VueloConAvion;
import model.ModelAvion;
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
                String fecha_salida = JOptionPane.showInputDialog("Ingresa la fecha de salida (yyyy-MM-dd)");
                LocalDate fecha = LocalDate.parse(fecha_salida, formatterDate);
                objVuelo.setFecha_salida(fecha);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error en patron, recuerda el formato (yyyy-MM-dd)");
                return;
            };

        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        try {
            String hora_salida = JOptionPane.showInputDialog("Ingresa la hora de salida (HH:mm:ss)");
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
    public static String listarVuelosString(){
        ModelVuelo objModelVuelo = new ModelVuelo();
        String listaDeVuelos  = "Lista de vuelos\n";


        for (Object objVuelo: objModelVuelo.listar()){
            listaDeVuelos += (VueloConAvion) objVuelo + "\n";
        }
        return listaDeVuelos;
    }
    public static void actualizarVuelo(){
        ModelVuelo objModelVuelo = new ModelVuelo();
        Vuelo objVuelo = new Vuelo();

        int id = Integer.parseInt(JOptionPane.showInputDialog(listarVuelosString() + "\n Ingresa el id del vuelo que deseas actualizar"));


        VueloConAvion vueloByID = (VueloConAvion) objModelVuelo.findByID(id);
        if (vueloByID == null || vueloByID.getVuelo() == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún vuelo con el ID proporcionado.");
            return;
        }

        String destino = JOptionPane.showInputDialog("Ingresa el destino del vuelo", vueloByID.getVuelo().getDestino());
        int id_avion = Integer.parseInt(JOptionPane.showInputDialog(ControllerAvion.listarAvionesString() + "\nIngresa el id del avion establecido para el viaje", vueloByID.getVuelo().getId_avion()));

        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            String fecha_salida = JOptionPane.showInputDialog("Ingresa la fecha de salida", vueloByID.getVuelo().getFecha_salida());
            LocalDate fecha = LocalDate.parse(fecha_salida, formatterDate);
            objVuelo.setFecha_salida(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de la fecha. Recuerda el formato (yyyy-MM-dd)");
            return;
        }

        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        try {
            String hora_salida = JOptionPane.showInputDialog("Ingresa la hora de salida", vueloByID.getVuelo().getHora_salida());
            LocalTime time = LocalTime.parse(hora_salida, formatterTime);
            objVuelo.setHora_salida(time);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de la hora. Recuerda el formato (HH:mm:ss)");
            return;
        }

        objVuelo.setDestino(destino);
        objVuelo.setId_avion(id_avion);
        objVuelo.setId_vuelo(id);

        // Actualizar el vuelo existente en la base de datos
        boolean actualizado = objModelVuelo.update(objVuelo);

        if (actualizado) {
            JOptionPane.showMessageDialog(null, "El vuelo se ha actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar el vuelo.");
        }
    }
    public static void eliminarVuelo(){
        ModelVuelo objModelVuelo = new ModelVuelo();
        Vuelo objVuelo = new Vuelo();

        int id = Integer.parseInt(JOptionPane.showInputDialog(listarVuelosString()+ "\n Ingrese el id del vuelo que desea eliminar"));

        objVuelo.setId_vuelo(id);

        boolean validacion = objModelVuelo.delete(objVuelo);


        if (validacion){
            JOptionPane.showMessageDialog(null, "Avion eliminado con exito" );
        }
    }




}
