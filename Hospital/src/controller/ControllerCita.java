package controller;

import entity.Cita;
import entity.Paciente;
import model.ModelCita;
import model.ModelPaciente;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ControllerCita {
    public static void crearCita(){
        ModelCita objModelCita = new ModelCita();
        Cita objCita = new Cita();

        int id_paciente = Integer.parseInt(JOptionPane.showInputDialog( ControllerPaciente.listarPacientesString() + "\n¿A que paciente pertenece la cita?"));
        int id_medico = Integer.parseInt(JOptionPane.showInputDialog( ControllerMedico.listarMedicosString() + "\n¿A cuál medico se le asignará la cita?"));
        String motivo = JOptionPane.showInputDialog("Ingrese el motivo de la cita");

        String hora_cita = JOptionPane.showInputDialog("Ingresa la hora de la cita (HH:mm:ss)");

        String fechaCita = JOptionPane.showInputDialog("Ingresa la fecha de la cita (yyyy-MM-dd)");


        /*Espacio para desarrollo de almacenamiento de hora*/

        /*Local time para hora*/
        try {
            //Formateamos la hora como deseemos
            LocalTime hora = LocalTime.parse(hora_cita);
        }catch (DateTimeParseException e){
            System.out.println("Error: Formato de hora inválido. Asegúrate de usar el formato HH:mm:ss");
            return;  // Terminar la creación de la cita si hay un error
        }

        /*Local date para fecha */

        try {

            DateTimeFormatter formatoDeFechaCita = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            LocalDate fecha = LocalDate.parse(fechaCita, formatoDeFechaCita);
        }catch (DateTimeParseException e){
            System.out.println("Error: Formato de fecha inválido. Asegúrate de usar el formato yyyy-MM-dd");
            return; // Terminar la creación de la cita si hay un error
        }

        objCita.setId_paciente(id_paciente);
        objCita.setId_medico(id_medico);
        objCita.setMotivo(motivo);
        objCita.setHora_cita(fechaCita + "T" + hora_cita); // Combinar fecha y hora en un solo String
        objCita.setFecha_cita(fechaCita);



        Cita cita = (Cita) objModelCita.create(objCita);
        JOptionPane.showMessageDialog(null, "CITA CREADA CON ÉXITO\n" + cita);


    }
    public static void listarCita(){
        ModelCita objModelCita = new ModelCita();
        String listaDeCitas = "LISTA CITAS \n";
        for (Object objCita: objModelCita.listar()){
            listaDeCitas += (Cita) objCita + "\n";
        }
        JOptionPane.showMessageDialog(null, listaDeCitas);
    }
    public static String listarCitaString(){
        ModelCita objModelCita = new ModelCita();
        String listaDeCitas = "LISTA CITAS \n";
        for (Object objCita: objModelCita.listar()){
            listaDeCitas += (Cita) objCita + "\n";
        }
        return listaDeCitas;
    }
    public static void actualizar(){
        ModelCita objModelCita = new ModelCita();
        Cita objCita = new Cita();


        int  id =  Integer.parseInt(JOptionPane.showInputDialog( listarCitaString()  + "Ingresa el id de la cita que desea actualizar"));
        int id_paciente = Integer.parseInt(JOptionPane.showInputDialog( ControllerPaciente.listarPacientesString() + "\n¿A que paciente pertenece la cita?"));
        int id_medico = Integer.parseInt(JOptionPane.showInputDialog( ControllerMedico.listarMedicosString() + "\n¿A cuál medico se le asignará la cita?"));
        String motivo = JOptionPane.showInputDialog("Ingrese el motivo de la cita");

        String hora_cita = JOptionPane.showInputDialog("Ingresa la hora de la cita (HH:mm:ss)");

        String fechaCita = JOptionPane.showInputDialog("Ingresa la fecha de la cita (yyyy-MM-dd)");

        /*Espacio para desarrollo de almacenamiento de hora*/

        /*Local time para hora*/
        try {
            //Formateamos la hora como deseemos
            LocalTime hora = LocalTime.parse(hora_cita);
        }catch (DateTimeParseException e){
            System.out.println("Error: Formato de hora inválido. Asegúrate de usar el formato HH:mm:ss");
            return;  // Terminar la creación de la cita si hay un error
        }

        /*Local date para fecha */

        try {

            DateTimeFormatter formatoDeFechaCita = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            LocalDate fecha = LocalDate.parse(fechaCita, formatoDeFechaCita);
        }catch (DateTimeParseException e){
            System.out.println("Error: Formato de fecha inválido. Asegúrate de usar el formato yyyy-MM-dd");
            return; // Terminar la creación de la cita si hay un error
        }

        objCita.setId(id);
        objCita.setId_paciente(id_paciente);
        objCita.setId_medico(id_medico);
        objCita.setMotivo(motivo);
        objCita.setHora_cita(fechaCita + "T" + hora_cita); // Combinar fecha y hora en un solo String
        objCita.setFecha_cita(fechaCita);




        JOptionPane.showMessageDialog(null, "CITA ACTUALIZADA CON ÉXITO\n");

        objModelCita.update(objCita);



    }
    public static void eliminar(){
        ModelCita objModelCita = new ModelCita();
        Cita objCita = new Cita();

        int id = Integer.parseInt(JOptionPane.showInputDialog(listarCitaString() + "\n Ingrese el id de la cita que desea eliminar"));

        objCita.setId(id);

        objModelCita.delete(objCita);
    }




}
