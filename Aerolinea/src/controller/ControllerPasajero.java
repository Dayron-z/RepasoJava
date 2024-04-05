package controller;

import entity.Avion;
import entity.Pasajero;
import model.ModelAvion;
import model.ModelPasajero;

import javax.swing.*;

public class ControllerPasajero {
    public static void crearPasajero(){
        ModelPasajero objModelPasajero = new ModelPasajero();
        Pasajero objPasajero = new Pasajero();

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del pasajero");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del pasajero");
        String documento_identidad = JOptionPane.showInputDialog("Ingrese el documento_identidad del pasajero");

        objPasajero.setNombre_pasajero(nombre);
        objPasajero.setApellido_pasajero(apellido);
        objPasajero.setDocumento_identidad(documento_identidad);



        Pasajero pasajero = (Pasajero) objModelPasajero.create(objPasajero);

        if (pasajero != null){
            JOptionPane.showMessageDialog(null, "El usuario se ha creado: \n" + pasajero);
        }

    }
    public static void listarPasajero(){
        ModelPasajero objModelPasajero = new ModelPasajero();
        String listaDePasajero  = "Lista pasajero\n";


        for (Object objPasajero: objModelPasajero.listar()){
            listaDePasajero += (Pasajero) objPasajero + "\n";
        }

        JOptionPane.showMessageDialog(null, listaDePasajero);
    }
    public static String listarPasajeroString(){
        ModelPasajero objModelPasajero = new ModelPasajero();
        String listaDePasajero  = "Lista pasajero\n";


        for (Object objPasajero: objModelPasajero.listar()){
            listaDePasajero += (Pasajero) objPasajero + "\n";
        }

        return listaDePasajero;
    }
    public static void actualizarPasajero(){
        ModelPasajero objModelPasajero = new ModelPasajero();
        Pasajero objPasajero = new Pasajero();

        int id = Integer.parseInt(JOptionPane.showInputDialog( listarPasajeroString() + "\nIngresa el id del pasajero que deseas actualizar"));

        Pasajero pasajero =  (Pasajero) objModelPasajero.findByID(id);

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del pasajero",pasajero.getNombre_pasajero());
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del pasajero", pasajero.getApellido_pasajero());
        String documento_identidad = JOptionPane.showInputDialog("Ingrese el documento_identidad del pasajero", pasajero.getDocumento_identidad());

        objPasajero.setNombre_pasajero(nombre);
        objPasajero.setApellido_pasajero(apellido);
        objPasajero.setDocumento_identidad(documento_identidad);
        objPasajero.setId(id);


        boolean validacion = objModelPasajero.update(objPasajero);

        if (validacion){
            JOptionPane.showMessageDialog(null, "Pasajero actualizado con exito" );
        }

    }
    public static void eliminarPasajero(){
        ModelPasajero objModelPasajero = new ModelPasajero();
        Pasajero objPasajero = new Pasajero();

        int id = Integer.parseInt(JOptionPane.showInputDialog(listarPasajeroString() + "\n Ingrese el id del pasajero que desea eliminar"));

        objPasajero.setId(id);


        boolean validacion = objModelPasajero.delete(objPasajero);;

        if (validacion){
            JOptionPane.showMessageDialog(null, "Pasajero eliminado con exito" );
        }


    }

}
