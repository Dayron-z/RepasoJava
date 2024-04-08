package repository;

import entity.Usuario;

import java.util.ArrayList;

public interface UserRepository {
    boolean registrarUsuario(Usuario usuario);
    ArrayList<Usuario> loginUsuario();
    boolean actualizarUsuario(Usuario usuario);



}
