package edu.espe.proyectou1.Repository;

import edu.espe.proyectou1.Model.Rol;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RolRepository {
    List<Rol> roles = new ArrayList<>();

    public List<Rol> findAll() {
        return roles;
    }
    public Rol save(Rol rol){
        roles.add(rol);
        return rol;
    }
    public void deleteById(String id) {
        for (Rol rol : roles) {
            if (rol.getId().equals(id)) {
                roles.remove(rol);
                break;
            }
        }
    }
    public Rol findById(String id) {
        for (Rol rol : roles) {
            if (rol.getId().equals(id)) {
                return rol;
            }
        }
        return null;
    }
    public void updateById(String id, Rol rol) {
        for (Rol rol1 : roles) {
            if (rol1.getId().equals(id)) {
                rol1.setName(rol.getName());
                rol1.setDescription(rol.getDescription());
            }
        }
    }
}
