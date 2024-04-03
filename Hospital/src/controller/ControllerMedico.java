package controller;

import entity.Especialidad;
import entity.Medico;
import model.ModelEspecialidad;
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
    public static void listarMedicos(){
        ModelMedico objModelMedico = new ModelMedico();
        String listaMedicos = "LISTA MEDICOS \n";
        for (Object objMedico: objModelMedico.listar()){
            listaMedicos += (Medico) objMedico + "\n";
        }
        JOptionPane.showMessageDialog(null, listaMedicos);
    }
    public static String listarMedicosString(){
        ModelMedico objModelMedico = new ModelMedico();
        String listaMedicos = "LISTA MEDICOS \n";
        for (Object objMedico: objModelMedico.listar()){
            listaMedicos += (Medico) objMedico + "\n";
        }
        return listaMedicos;
    }
    public static void actualizar (){
        ModelMedico objModelMedico = new ModelMedico();
        Medico objMedico = new Medico();

        int id = Integer.parseInt(JOptionPane.showInputDialog(listarMedicosString() + "Ingresa el id del medico que desea editar"));
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre del medico");
        String apellido = JOptionPane.showInputDialog("Ingresa el apellido del medico");
        int idEspecialidad =  Integer.parseInt(JOptionPane.showInputDialog( ControllerEspecialidad.listarEspecialidadesString()+ "Ingresa el id especialidad del medico que desea editar"));


        objMedico.setNombre(nombre);
        objMedico.setApellido(apellido);
        objMedico.setId(id);
        objMedico.setId_especialidad(idEspecialidad);


        objModelMedico.update(objMedico);


        JOptionPane.showMessageDialog(null,"se actualizo correctamente");
    }
}
