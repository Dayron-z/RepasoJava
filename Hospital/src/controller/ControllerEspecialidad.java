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

        Especialidad  especialidad = (Especialidad) objModel.create(objEspecialidad);

        JOptionPane.showMessageDialog(null, "El usuario se ha creado: \n" + especialidad);
    }
    public static void listarEspecialidades(){
        //Traemos el objModel, para acceder a sus métodos
        ModelEspecialidad objModelEspecialidad = new ModelEspecialidad();
        String listaEspecialidades = "LISTA ESPECIALIDADES \n";
            //Esto es un arraylist de Object
        for (Object objEspecialidad: objModelEspecialidad.listar()){
            listaEspecialidades += (Especialidad) objEspecialidad + "\n";
        }

        JOptionPane.showMessageDialog(null, listaEspecialidades);

    }
    public static String listarEspecialidadesString(){
        //Traemos el objModel, para acceder a sus métodos
        ModelEspecialidad objModelEspecialidad = new ModelEspecialidad();
        String listaEspecialidades = "LISTA ESPECIALIDADES \n";
        //Esto es un arraylist de Object
        for (Object objEspecialidad: objModelEspecialidad.listar()){
            listaEspecialidades += (Especialidad) objEspecialidad + "\n";
        }

        return listaEspecialidades;
    };
    public static void actualizar (){
        ModelEspecialidad objModel = new ModelEspecialidad();
        Especialidad objEspecialidad = new Especialidad();

        int id = Integer.parseInt(JOptionPane.showInputDialog( listarEspecialidadesString() + "\nIngresa el id del usuario que deseas actualizar"));
        String nombre =JOptionPane.showInputDialog("ingresa el nombre que deseas actualizar");
        String descripcion = JOptionPane.showInputDialog("ingresa la nueva descripcion");

        objEspecialidad.setId(id);
        objEspecialidad.setNombre(nombre);
        objEspecialidad.setDescripcion(descripcion);


        objModel.update(objEspecialidad);



        JOptionPane.showMessageDialog(null,"se actualizo correctamente");
    }
    public static void eliminar(){
        ModelEspecialidad objModelEspecialidad = new ModelEspecialidad();
        Especialidad objEspecialidad = new Especialidad();

        int id = Integer.parseInt(JOptionPane.showInputDialog(listarEspecialidadesString() + "\n Ingrese el id de la especialidad  que desea eliminar"));

        objEspecialidad.setId(id);


        System.out.println(objEspecialidad);
        objModelEspecialidad.delete(objEspecialidad);

    }





}
