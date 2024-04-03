package controller;

import entity.Medico;
import model.ModelMedico;

import javax.swing.*;

public class ControllerMedico {
    public static void crearMedico(){
        ModelMedico objModelMedico = new ModelMedico();
        Medico objMedico = new Medico();

        String nombre = JOptionPane.showInputDialog("Ingresa el nombre del medico");
        String apellido = JOptionPane.showInputDialog("Ingresa el apellido del medico");
        int idEspecialidad = Integer.parseInt(JOptionPane.showInputDialog( ControllerEspecialidad.listarEspecialidadesString() + "Ingresa el id especialidad del medico"));

        objMedico.setNombre(nombre);
        objMedico.setApellido(apellido);
        objMedico.setId_especialidad(idEspecialidad);

        Medico medico = (Medico)objModelMedico.create(objMedico);


        JOptionPane.showMessageDialog(null, medico + "\nMedico agregado correctamente");


        /*        nombre, apellidos, id_especialidad*/


    }
}
