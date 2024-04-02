package controller;

import entity.Especialidad;
import model.ModelEspecialidad;

import javax.swing.*;

public class ControllerEspecialidad {
    public static void crearEspecialidad(){
        //Traemos el objModel, para acceder a sus métodos
        ModelEspecialidad objModel = new ModelEspecialidad();
        Especialidad objEspecialidad = new Especialidad();

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la especialidad");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la especialidad");

        objEspecialidad.setNombre(nombre);
        objEspecialidad.setDescripcion(descripcion);

        objModel.create(objEspecialidad);


    }
}
