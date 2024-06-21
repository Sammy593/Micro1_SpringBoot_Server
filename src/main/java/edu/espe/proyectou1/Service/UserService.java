package edu.espe.proyectou1.Service;

import edu.espe.proyectou1.Model.Rol;
import edu.espe.proyectou1.Model.User;
import edu.espe.proyectou1.Payload.response.UserWithCounts;
import edu.espe.proyectou1.Repository.RolRepository;
import edu.espe.proyectou1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findAllCombo() {
        return userRepository.findAllCombo();
    }

    public ResponseEntity<?> save(User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteById(String id) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findById(id));
        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> findById(String id) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findById(id));
        if (userOptional.isPresent()) {
            RestTemplate restTemplate = new RestTemplate();
            // Cuantos proyectos lidera
            String url1 = "http://localhost:8080/project/countProjectsByUserId/" + id;
            ResponseEntity<String> response1 = restTemplate.getForEntity(url1, String.class);
            String countProject = response1.getBody();
            // Cuantas tareas realiza
            String url2 = "http://localhost:8080/task/countTasksByUserId/" + id;
            ResponseEntity<String> response2 = restTemplate.getForEntity(url2, String.class);
            String countTask = response2.getBody();

            UserWithCounts userRes = new UserWithCounts();
            userRes.setUser(userOptional.get());
            userRes.setNumProjects(countProject);
            userRes.setNumTasks(countTask);

            Optional<Rol> rolOptional = Optional.ofNullable(rolRepository.findById(userOptional.get().getIdRol()));
            rolOptional.ifPresent(rol -> userRes.setRolName(rol.getName()));
            return new ResponseEntity<>(userRes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> updateById(String id, User user) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findById(id));
        if (userOptional.isPresent()) {
            userRepository.updateById(id, user);
            return new ResponseEntity<>("User updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
