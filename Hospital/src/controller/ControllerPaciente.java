package controller;

import entity.Especialidad;
import entity.Medico;
import entity.Paciente;
import model.ModelEspecialidad;
import model.ModelMedico;
import model.ModelPaciente;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.zip.DataFormatException;

public class ControllerPaciente {
    public static void crearPaciente(){
        ModelPaciente objModelPaciente = new ModelPaciente();
        Paciente objPaciente = new Paciente();


        String nombre = JOptionPane.showInputDialog("Ingresa el nombre del paciente");
        String apellidos = JOptionPane.showInputDialog("Ingresa el apellido del paciente");
        String documento_identidad = JOptionPane.showInputDialog("Ingresa el documento de identidad");

        String fecha_nacimiento = JOptionPane.showInputDialog("Ingresa la fecha de nacimiento (yyyy-MM-dd) ");
        DateTimeFormatter formatoDeFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");





        try {
           LocalDate.parse(fecha_nacimiento, formatoDeFecha);

            objPaciente.setNombre(nombre);
            objPaciente.setApellidos(apellidos);
            objPaciente.setFecha_nacimiento(fecha_nacimiento);
            objPaciente.setDocumento_identidad(documento_identidad);

            JOptionPane.showMessageDialog(null, "Se ha creado correctamente");

            Paciente paciente = (Paciente) objModelPaciente.create(objPaciente);
            JOptionPane.showMessageDialog(null, paciente + "\nMedico agregado correctamente");

        }catch (DateTimeParseException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }
    public static void listarPacientes(){
        ModelPaciente objModelPaciente = new ModelPaciente();
        String listaPacientes = "LISTA PACIENTES \n";
        for (Object objMedico: objModelPaciente.listar()){
            listaPacientes += (Paciente) objMedico + "\n";
        }
        JOptionPane.showMessageDialog(null, listaPacientes);
    }
    public static String listarPacientesString(){
        ModelPaciente objModelPaciente = new ModelPaciente();
        String listaPacientes = "LISTA PACIENTES \n";
        for (Object objPaciente: objModelPaciente.listar()){
            listaPacientes += (Paciente) objPaciente + "\n";
        }
        return  listaPacientes;
    }
    public static void actualizar (){
        ModelPaciente objModelPaciente = new ModelPaciente();
        Paciente objPaciente = new Paciente();

        int  id =  Integer.parseInt(JOptionPane.showInputDialog( listarPacientesString()  + "Ingresa el id del usuario que desea eliminar"));

        String nombre = JOptionPane.showInputDialog("Ingresa el nombre del paciente");
        String apellidos = JOptionPane.showInputDialog("Ingresa el apellido del paciente");
        String documento_identidad = JOptionPane.showInputDialog("Ingresa el documento de identidad");
        String fecha_nacimiento = JOptionPane.showInputDialog("Ingresa la fecha de nacimiento ");
        DateTimeFormatter formatoDeFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        try {
            LocalDate.parse(fecha_nacimiento, formatoDeFecha);

            objPaciente.setId(id);
            objPaciente.setNombre(nombre);
            objPaciente.setApellidos(apellidos);
            objPaciente.setFecha_nacimiento(fecha_nacimiento);
            objPaciente.setDocumento_identidad(documento_identidad);


            objModelPaciente.update(objPaciente);
            JOptionPane.showMessageDialog(null, "Se ha creado correctamente");
        }catch (DateTimeParseException e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }


    }
    public static void eliminar (){
        ModelPaciente objModelPaciente = new ModelPaciente();
        Paciente objPaciente = new Paciente();

        int id = Integer.parseInt(JOptionPane.showInputDialog(listarPacientesString() + "\n Ingrese el id del paciente que desea eliminar"));

        objPaciente.setId(id);

        objModelPaciente.delete(objPaciente);
    }
}
