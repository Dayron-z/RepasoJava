package Controller;

import Entity.Author;
import Model.AuthorModel;

import javax.swing.*;

public class AuthorController {
   public static void insertAuthors(){
       AuthorModel objAuthorModel = new AuthorModel();
       Author objAuthor = new Author();
       /*-----------------------------------------------------------------------------------*/

       String name = JOptionPane.showInputDialog("Enter the author name");
       String nationality = JOptionPane.showInputDialog("Enter the author nationality");
       /*-----------------------------------------------------------------------------------*/
       objAuthor.setName(name);
       objAuthor.setNationality(nationality);
       /*-----------------------------------------------------------------------------------*/
       Author authorData =  (Author) objAuthorModel.insertAuthor(objAuthor);
       /*-----------------------------------------------------------------------------------*/
       JOptionPane.showMessageDialog(null, "The author has been created successful\n" + authorData.toString());
   }

   public static void showAuthors(){
       AuthorModel objAutor = new AuthorModel();

       String listAuthors = "This is the authors list 📕\n";

      for (Object author: objAutor.showAuthor()){
          listAuthors += author.toString()+ "\n";
      }

      JOptionPane.showMessageDialog(null, listAuthors);
   }
   public static String showAuthorsString(){
        AuthorModel objAutor = new AuthorModel();

        String listAuthors = "This is the authors list 📕\n";

        for (Object author: objAutor.showAuthor()){
            listAuthors += author.toString()+ "\n";
        }

        return listAuthors;
    }


    public static void updateAuthors(){
       AuthorModel objAuthorModel = new AuthorModel();
       Author objAuthor = new Author();



           String id = JOptionPane.showInputDialog( showAuthorsString() +"\nEnter the id of the author that you want to edit");
           String name = JOptionPane.showInputDialog("Enter the new author name");
           String nationality = JOptionPane.showInputDialog("Enter the new author nationality");

           objAuthor.setId(id);
           objAuthor.setName(name);
           objAuthor.setNationality(nationality);

           JOptionPane.showMessageDialog(null, "The user has been modified successfully");

           objAuthorModel.update(objAuthor);




    }



}
