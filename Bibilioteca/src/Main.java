import Controller.AuthorController;
import Database.ConfigDB;

import javax.swing.*;
import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String option;

        do {
            option = JOptionPane.showInputDialog("""
                Enter an option 
                1 - Author options
                2 - Books options 
                3 - Exit 
                """);

            switch (option){
                case "1":
                    String authorOptions;

                    do {
                        authorOptions = JOptionPane.showInputDialog("""
                                Enter an option
                                1- Register author
                                2 - Show authors
                                3 - Update author 
                                4 - Delete author
                                5 - Find author by id  
                                6 - Exit
                                """);

                        switch (authorOptions){
                            case "1":
                                AuthorController.insertAuthors();
                                break;
                            case "2":
                                AuthorController.showAuthors();
                                break;
                            case "3":
                                AuthorController.updateAuthors();
                                break;
                            case "4":
                                AuthorController.deleteAuthors();
                                break;
                            case "5":
                                AuthorController.findAuthotById();
                                break;
                        }
                    }while (!authorOptions.equals("6"));
                    break;
            }
        }while (!option.equals("3"));
    }
}