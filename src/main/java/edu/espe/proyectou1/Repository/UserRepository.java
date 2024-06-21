package edu.espe.proyectou1.Repository;

import edu.espe.proyectou1.Model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> usuarios = new ArrayList<>();

    public List<User> findAll() {
        return usuarios;
    }

    public List<User> findAllCombo() {
        List<User> usuariosActivos = new ArrayList<>();
        for (User user : usuarios) {
            if (user.getState().equals("Activo")) {
                usuariosActivos.add(user);
            }
        }
        return usuariosActivos;
    }

    public User save(User user) {
        usuarios.removeIf(t -> t.getId().equals(user.getId()));
        usuarios.add(user);
        return user;
    }
    public void deleteById(String id) {
        for (User person : usuarios) {
            if (person.getId().equals(id)) {
                usuarios.remove(person);
                break;
            }
        }
    }
    public User findById(String id) {
        for (User user : usuarios) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
    public void updateById(String id, User usuario) {
        for (User usuario1 : usuarios) {
            if (usuario1.getId().equals(id)) {
                usuario1.setName(usuario.getName());
                usuario1.setLastname(usuario.getLastname());
                usuario1.setPhone(usuario.getPhone());
                usuario1.setEmail(usuario.getEmail());
                usuario1.setIdRol(usuario.getIdRol());
                usuario1.setState(usuario.getState());
            }
        }
    }

}
