import controller.ControllerCita;
import controller.ControllerEspecialidad;
import controller.ControllerMedico;
import controller.ControllerPaciente;
import database.ConfigDB;
import model.ModelEspecialidad;
import model.ModelMedico;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int opcion = 0, opcionEspecialidad = 0, opcionMedico = 0, opcionPaciente = 0 , opcionCita = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    Ingrese una opción
                    1 - CRUD ESPECIALIDAD
                    2 - CRUD MEDICO
                    3 - CRUD PACIENTE
                    4 - CRUD CITA
                    """));

            switch (opcion){
                case 1:
                    do {
                        opcionEspecialidad = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear especialidad
                                2 - Eliminar especialidad 
                                3 - Actualizar especialidad
                                4 - Listar especialidades
                                5 - Salir 
                                """));

                        switch (opcionEspecialidad){
                            case 1:
                                ControllerEspecialidad.crearEspecialidad();
                                break;
                            case 2:
                                ControllerEspecialidad.eliminar();
                                break;
                            case 3:
                                ControllerEspecialidad.actualizar();
                                break;
                            case 4:
                                ControllerEspecialidad.listarEspecialidades();
                                break;
                        }
                    }while (opcionEspecialidad != 5);

                    break;

                case 2:
                    do {
                        opcionMedico = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear medico
                                2 - Eliminar medico 
                                3 - Actualizar medico
                                4 - Listar medicos 
                                5 - Buscar medicos por especialidad 
                                6 - Salir
                                """));

                        switch (opcionMedico){
                            case 1:
                                ControllerMedico.crearMedico();
                                break;
                            case 2:
                                ControllerMedico.eliminar();
                                break;
                            case 3:
                                ControllerMedico.actualizar();
                                break;
                            case 4:
                                ControllerMedico.listarMedicos();
                                break;
                            case 5:
                                ControllerMedico.buscarMedicoPorEspecialidad();
                                break;
                        }


                    }while (opcionMedico != 6);
                    break;

                case 3:
                    do {
                         opcionPaciente = Integer.parseInt(JOptionPane.showInputDialog("""
                                 1 - Crear paciente 
                                 2 - Eliminar paciente 
                                 3 - Actualizar paciente  
                                 4 - Listar pacientes 
                                 5 - Buscar paciente por cédula
                                 6 - Salir 
                                 """));

                         switch (opcionPaciente){
                             case 1:
                                 ControllerPaciente.crearPaciente();
                                 break;
                             case 2:
                                 ControllerPaciente.eliminar();
                                 break;
                             case 3:
                                 ControllerPaciente.actualizar();
                                 break;
                             case 4:
                                 ControllerPaciente.listarPacientes();
                                 break;
                             case 5:
                                 ControllerPaciente.buscarPacientePorCedula();
                                 break;
                         }

                    }while (opcionPaciente != 6);
                    break;

                case 4:
                    do {
                        opcionCita = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear cita
                                2 - Eliminar cita 
                                3 - Actualizar cita 
                                4 - Listar cita 
                                5 - listar cita por fecha 
                                6 - Salir
                                
                                """));

                        switch (opcionCita){
                            case 1:
                                ControllerCita.crearCita();
                                break;
                            case 2:
                                ControllerCita.eliminar();
                                break;
                            case 3:
                                ControllerCita.actualizar();
                                break;
                            case 4:
                                ControllerCita.listarCita();
                                break;
                            case 5:
                                ControllerCita.buscarCitasPorFecha();
                                break;
                        }
                    }while (opcionCita != 6);
                    break;
            }


        }while (opcion != 5);


    }
}