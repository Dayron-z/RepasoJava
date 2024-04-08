package controller;

import entity.TipoUsuario;
import entity.Usuario;
import model.UserModel;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class UserController {
    UserModel objUserModel = new UserModel();
    public void registrarUsuario(){
        String opcionTipoUsuario;

        // Generar un UUID para id (UUID se refiere al "Universally Unique Identifier" o Identificador Único Universal)
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().substring(0, 10);


        TipoUsuario tipoUsuario = null;
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre");
        String email =  JOptionPane.showInputDialog("Ingrese el email");
        String contraseña =  JOptionPane.showInputDialog("Ingrese su contraseña");


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

        Usuario objUsuario = new Usuario(id,nombre, email, contraseña, tipoUsuario);

        objUserModel.registrarUsuario(objUsuario);
    }
    public void loginUsuario(){

        String email = JOptionPane.showInputDialog( "Ingrese su email");
        String contraseña = JOptionPane.showInputDialog("Ingrese su contraseña");
         for (Usuario usuario: objUserModel.loginUsuario()){
             if (email.equals(usuario.getEmail())  && contraseña.equals(usuario.getContraseña())){
                 JOptionPane.showMessageDialog(null, "El logeo ha sido éxitoso");
             }else{
                 JOptionPane.showMessageDialog(null, "Usuario no registrado");
             }
         }
    }
    public String listarUsuario(){

        String listaDeUsuarios = "Lista de usuarios\n";

        for (Usuario usuario: objUserModel.loginUsuario()){
            listaDeUsuarios += usuario;
        }


        return listaDeUsuarios;
    }
    public void actualizarUsuario(){
        String opcionTipoUsuario;

        String id = JOptionPane.showInputDialog("Ingresa id del usuario que deseas editar\n" + listarUsuario());
        String nombre = JOptionPane.showInputDialog("Ingresa el nuevo nombre de usuario");
        String email =JOptionPane.showInputDialog("Ingresa el nuevo email de usuario");
        String constraseña =JOptionPane.showInputDialog("Ingresa la nueva contraseña");

        TipoUsuario tipoUsuario = null;

        opcionTipoUsuario = JOptionPane.showInputDialog("""
                Ingresa el nuevo tipo de usuario
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


        Usuario objUsuario = new Usuario(id, nombre, email, constraseña, tipoUsuario);
        objUserModel.actualizarUsuario(objUsuario);
        JOptionPane.showMessageDialog(null, "Usuario editado satisfactoriamente");

    }
}
