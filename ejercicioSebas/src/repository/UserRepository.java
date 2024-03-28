package repository;

import entity.Usuario;

public interface UserRepository {
    boolean registrarUsuario(Usuario usuario);
    boolean loginUsuario(Usuario usuario);
}
