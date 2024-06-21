package edu.espe.proyectou1.Service;

import edu.espe.proyectou1.Model.Rol;
import edu.espe.proyectou1.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;


    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    public ResponseEntity<?> save(Rol rol) {
        return new ResponseEntity<>(rolRepository.save(rol), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(String id) {
        Optional<Rol> rolOptional = Optional.ofNullable(rolRepository.findById(id));
        if (rolOptional.isPresent()) {
            rolRepository.deleteById(id);
            return new ResponseEntity<>(rolOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Rol not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> findById(String id) {
        Optional<Rol> rolOptional = Optional.ofNullable(rolRepository.findById(id));
        if (rolOptional.isPresent()) {
            return new ResponseEntity<>(rolOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Rol not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> updateById(String id, Rol rol) {
        Optional<Rol> rolOptional = Optional.ofNullable(rolRepository.findById(id));
        if (rolOptional.isPresent()) {
            rolRepository.updateById(id, rol);
            return new ResponseEntity<>("Rol updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Rol not found", HttpStatus.NOT_FOUND);
        }
    }
}
