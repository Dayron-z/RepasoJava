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


           if (objAuthorModel.update(objAuthor)){
               JOptionPane.showMessageDialog(null, "The user has been modified successfully");
           }else{
               JOptionPane.showMessageDialog(null, "The user with this ID does not exist");
           }
    }
    public static void deleteAuthors(){
       AuthorModel objAuthorModel = new AuthorModel();


       String idDelete =  JOptionPane.showInputDialog( showAuthorsString() + "\n Enter the ID you want to remove");


       if (objAuthorModel.delete(idDelete)){
           JOptionPane.showMessageDialog(null, "User successfully removed");
       }else{
           JOptionPane.showMessageDialog(null, "error");
       }


    }
    public static void findAuthotById(){
       AuthorModel objAuthorModel  = new AuthorModel();

       String id = JOptionPane.showInputDialog("Enter the ID of the author you want to find.");
       Author objAuthor =  (Author) objAuthorModel.findByid(id);

       if (objAuthor.getId() == null){
           JOptionPane.showMessageDialog(null, "No existe");
           return;
       }


       JOptionPane.showMessageDialog(null, "Author found\n" + objAuthor);

    }

}
