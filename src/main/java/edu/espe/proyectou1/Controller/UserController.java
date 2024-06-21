package edu.espe.proyectou1.Controller;

import edu.espe.proyectou1.Model.User;
import edu.espe.proyectou1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping(value = "/listUsers")
    public List<User> listUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/listUsersCombo")
    public List<User> listUsersCombo() {
        return userService.findAllCombo();
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        return userService.deleteById(id);
    }


    @PutMapping(value = "/updateById/{id}")
    public ResponseEntity<?> updateById(@PathVariable String id, @RequestBody User user) {
        return userService.updateById(id, user);
    }
}
