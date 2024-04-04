package model;
import database.ConfigDB;
import entity.Especialidad;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class ModelEspecialidad implements CRUD {
    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> listaDeEspecialides = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();
        
        try {
            String sql = "SELECT * FROM especialidad";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            
            ResultSet objResult =  objPrepare.executeQuery(); 
            
            while (objResult.next()){
                Especialidad objEspecialidad = new Especialidad();
                objEspecialidad.setNombre(objResult.getString("nombre"));
                objEspecialidad.setDescripcion(objResult.getString("descripcion"));
                objEspecialidad.setId(objResult.getInt("id_especialidad"));
                
                listaDeEspecialides.add(objEspecialidad);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listaDeEspecialides;
    }
    @Override
    public Object create(Object obj) {
        Especialidad objEspecialidad = (Especialidad) obj;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "INSERT INTO especialidad (nombre, descripcion) VALUES (?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objEspecialidad.getNombre());
            objPrepare.setString(2, objEspecialidad.getDescripcion());

            objPrepare.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"
             + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objEspecialidad;
    }
    @Override
    public boolean update(Object obj) {
        Especialidad objEspecialidad = (Especialidad) obj;
        Connection objConexion = ConfigDB.openConnection();
        boolean isUpdate = false;

        try {
            String sql = "UPDATE especialidad SET nombre = ?, descripcion = ? WHERE id_especialidad = ?;";
            PreparedStatement objPrepare =  objConexion.prepareStatement(sql);

            objPrepare.setString(1, objEspecialidad.getNombre());
            objPrepare.setString(2, objEspecialidad.getDescripcion());
            objPrepare.setInt(3,objEspecialidad.getId());

            int filasAfectadas =  objPrepare.executeUpdate();

            if (filasAfectadas > 0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null,"Actualizado con exito" );
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdate;
    }
    @Override
    public boolean delete(Object obj) {

        boolean isDeleted = false;

        Especialidad objEspecialidad = (Especialidad) obj;
        Connection objConnection = ConfigDB.openConnection();
        try {
/*            DELETE FROM empleados
            WHERE departamento = 'Ventas';*/
           String sql = "DELETE FROM especialidad WHERE id_especialidad = ?;";
           PreparedStatement objPrepare = objConnection.prepareStatement(sql);


           objPrepare.setInt(1, objEspecialidad.getId());

           int filasAfectadas = objPrepare.executeUpdate();

            System.out.println(filasAfectadas);
           if (filasAfectadas > 0){
               JOptionPane.showMessageDialog(null, "Especialidad eliminada satisfactorimente");
               isDeleted = true;
           }


        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return isDeleted;
    }
}
