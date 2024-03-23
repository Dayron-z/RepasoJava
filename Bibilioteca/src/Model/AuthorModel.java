package Model;

import Database.ConfigDB;
import Entity.Author;
import Interface.CRUD;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorModel implements CRUD {

    @Override
    public Object insertAuthor(Object obj) {
        //We need use the "Get and set" of the entity
        Author objAuthor = (Author) obj;

        Connection objConnection = ConfigDB.openConnection();


        try {
            String sql = "INSERT INTO author (name, nationality) VALUES (?, ?);";
            /*prepared statement   -->  Declaración preparada*/
            int objStatement =  Statement.RETURN_GENERATED_KEYS;
            /*-----------------------------------------------------------------------------------*/
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, objStatement);
            /*-----------------------------------------------------------------------------------*/
            //After of the preparation we add values ---> ? ?
            objPrepare.setString(1, objAuthor.getName());
            objPrepare.setString(2, objAuthor.getNationality());

            objPrepare.execute();
            /*-----------------------------------------------------------------------------------*/
            /*Para este resultset no almacenamos ningun execute, sino las llaves que tiene asignadas el objPrepare despues del execute*/
            ResultSet objSet = objPrepare.getGeneratedKeys();
            /*Error principal en el repaso, tener presente y repasar*/
            /*-----------------------------------------------------------------------------------*/
            while (objSet.next()){
                //GENERATED_KEYS it's will recuperate for its position
               objAuthor.setId(objSet.getString(1));    ;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objAuthor;
    }

    @Override
    public List<Object> showAuthor() {
        ArrayList<Object>authorsList = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM Author";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);


            //Los while siempre se hacen con el resultSet
            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Author objAuthor = new Author();
                objAuthor.setName(objResult.getString("name"));
                objAuthor.setNationality(objResult.getString("nationality"));
                objAuthor.setId(objResult.getString("id"));


                authorsList.add(objAuthor);

            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "There is a error" + e.getMessage());
        }
        return authorsList;
    }

    @Override
    public boolean update(Object obj) {
        boolean isUpdated = false;
        Author objAuthor = (Author) obj;

        Connection objConnection = ConfigDB.openConnection();


        try {


            String sql = "UPDATE Author SET name = ?, nationality = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objAuthor.getName());
            objPrepare.setString(2, objAuthor.getNationality());
            objPrepare.setString(3, objAuthor.getId());

            int  totalRowsAffected = objPrepare.executeUpdate();


            if (totalRowsAffected > 0){
                isUpdated = true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error with the statement "  + e.getMessage() );
        }

        ConfigDB.closeConnection();
        return isUpdated;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }
}
