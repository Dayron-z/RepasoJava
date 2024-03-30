import connection.ConfigDB;
import controller.UserController;

import javax.swing.*;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserController objUserController = new UserController();

        int opcion = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    Ingrese una opción
                    1 - Ingresar
                    2 - Registar usuario
                    3-  Actulizar usuario
                    3 - Salir del sistema
                    """));

            switch (opcion){
                case 1:
                    objUserController.loginUsuario();
                    break;
                case 2:
                    objUserController.registrarUsuario();
                    break;
                case 3:
                    objUserController.actualizarUsuario();
                    break;
            }

        }while (opcion != 4);

        }
    }