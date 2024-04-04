package controller;

import entity.Especialidad;
import entity.Medico;
import model.ModelEspecialidad;
import model.ModelMedico;

import javax.swing.*;
import java.util.ArrayList;

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

    }
    public static void eliminar (){
        ModelMedico objModelMedico  = new ModelMedico();
        Medico objMedico = new Medico();

        int id = Integer.parseInt(JOptionPane.showInputDialog(listarMedicosString() + "\n Ingrese el id del medico que desea eliminar"));

        objMedico.setId(id);


        objModelMedico.delete(objMedico);

    }

    public static void buscarMedicoPorEspecialidad(){
        ModelMedico objModelMedico = new ModelMedico();

        String listaMedicos = "LISTA MEDICOS POR ESPECIALIDAD ESPECIFICA \n";

        int id = Integer.parseInt(JOptionPane.showInputDialog(ControllerEspecialidad.listarEspecialidadesString()  +"\nIngrese el id de la especialidad por la cual desea filtrar los medicos"));

        ArrayList <Object> ListaMedicosPorEspecialidad = objModelMedico.buscarPorEspecialidad(id);


        for (Object objMedico: ListaMedicosPorEspecialidad){
            listaMedicos += objMedico;
        }

        JOptionPane.showMessageDialog(null, listaMedicos);
    }


}
