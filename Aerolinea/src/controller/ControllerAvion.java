package controller;

import entity.Avion;
import model.ModelAvion;

import javax.swing.*;

public class ControllerAvion {

    public static void crearAvion(){
        ModelAvion objModelAvion = new ModelAvion();
        Avion objAvion = new Avion();

        String modelo = JOptionPane.showInputDialog("Ingrese el modelo del avion");
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad del avion"));


        objAvion.setModelo(modelo);
        objAvion.setCapacidad(capacidad);


        Avion avion = (Avion) objModelAvion.create(objAvion);

        if (avion != null){
            JOptionPane.showMessageDialog(null, "El usuario se ha creado: \n" + avion);
        }

    }
    public static void listarAviones(){
        ModelAvion objModelAvion = new ModelAvion();
        String listaDeAviones = "Lista aviones \n";


        for (Object objAvion: objModelAvion.listar()){
            listaDeAviones += (Avion) objAvion + "\n";
        }

        JOptionPane.showMessageDialog(null, listaDeAviones);
    }
    public static String listarAvionesString(){
        ModelAvion objModelAvion = new ModelAvion();
        String listaDeAviones = "Lista aviones \n";


        for (Object objAvion: objModelAvion.listar()){
            listaDeAviones += (Avion) objAvion + "\n";
        }

        return listaDeAviones;
    }
    public static void actualizarAvion(){
        ModelAvion objModelAvion = new ModelAvion();
        Avion objAvion = new Avion();

        int id = Integer.parseInt(JOptionPane.showInputDialog( listarAvionesString() + "\nIngresa el id del avion que deseas actualizar"));
        String modelo =JOptionPane.showInputDialog("ingresa el nombre del modelo");
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la capacidad del avion"));

        objAvion.setId(id);
        objAvion.setModelo(modelo);
        objAvion.setCapacidad(capacidad);


        boolean validacion = objModelAvion.update(objAvion);

        if (validacion){
            JOptionPane.showMessageDialog(null, "Avion actualizado con exito" );
        }

    }




}
