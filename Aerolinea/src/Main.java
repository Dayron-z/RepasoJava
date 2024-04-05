import controller.ControllerAvion;
import controller.ControllerPasajero;
import controller.ControllerVuelo;


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
                                ControllerAvion.crearAvion();
                                break;
                            case 2:
                                ControllerAvion.eliminarAvion();
                                break;
                            case 3:
                                ControllerAvion.actualizarAvion();
                                break;
                            case 4:
                                ControllerAvion.listarAviones();
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
                                ControllerPasajero.crearPasajero();
                                break;
                            case 2:
                                ControllerPasajero.eliminarPasajero();
                                break;
                            case 3:
                                ControllerPasajero.actualizarPasajero();
                                break;
                            case 4:
                                ControllerPasajero.listarPasajero();
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
                                ControllerVuelo.crearVuelo();
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                ControllerVuelo.listarVuelos();
                                break;
                        }
                    }while (opcionVuelo != 5);
                    break;
            }


        }while (opcion != 5);


    }
}