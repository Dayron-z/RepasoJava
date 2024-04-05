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
        int opcion = 0, opcionAvion = 0, opcionPasajero = 0, opcionReservacion = 0 , opcionVuelo = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    Ingrese una opción
                    1 - CRUD AVION
                    2 - CRUD PASAJERO
                    3 - CRUD RESERVACION
                    4 - CRUD VUELO
                    """));

            switch (opcion){
                case 1:
                    do {
                        opcionAvion = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear avion
                                2 - Eliminar avion 
                                3 - Actualizar avion
                                4 - Listar avion
                                5 - Salir 
                                """));

                        switch (opcionAvion){
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
                    }while (opcionAvion != 5);

                    break;

                case 2:
                    do {
                        opcionPasajero = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear pasajero
                                2 - Eliminar pasajero 
                                3 - Actualizar pasajero
                                4 - Listar pasajero
                                5 - Salir 
                                """));

                        switch (opcionPasajero){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }
                    }while (opcionPasajero != 5);
                    break;

                case 3:
                    do {
                        opcionReservacion = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear reservacion
                                2 - Eliminar reservacion 
                                3 - Actualizar reservacion
                                4 - Listar reservacion
                                5 - Salir 
                                 """));

                        switch (opcionReservacion){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }

                    }while (opcionReservacion != 5);
                    break;

                case 4:
                    do {
                        opcionVuelo = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear vuelo
                                2 - Eliminar vuelo 
                                3 - Actualizar vuelo 
                                4 - Listar vuelo 
                                6 - Salir
                                
                                """));

                        switch (opcionVuelo){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }
                    }while (opcionVuelo != 5);
                    break;
            }


        }while (opcion != 5);


    }
}