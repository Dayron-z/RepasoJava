package controller;

import entity.TipoUsuario;
import model.UserModel;

import javax.swing.*;
import java.time.LocalDate;

public class UserController {
    UserModel objUserModel;
    public static void registrarUsuario(){
        //Generamos id por fecha
        LocalDate fechaActual = LocalDate.now();
        String id = fechaActual.toString();
        String opcionTipoUsuario;


        TipoUsuario tipoUsuario;

        JOptionPane.showInputDialog("Ingrese su nombre");
        JOptionPane.showInputDialog("Ingrese el email");
        JOptionPane.showInputDialog("Ingrese su contraseña");

        opcionTipoUsuario = JOptionPane.showInputDialog("""
                Que tipo de usuario
                1 - VENDEDOR
                2 - COMPRADOR
                """);


        switch (opcionTipoUsuario){
            case "1":
                tipoUsuario = TipoUsuario.VENDEDEDOR;
                break;
            case "2":
                tipoUsuario = TipoUsuario.COMPRADOR;
        }



/*        private String id;
        private String nombre;
        private String email;
        private String contraseña;
        private TipoUsuario tipo;*/
    }
}
