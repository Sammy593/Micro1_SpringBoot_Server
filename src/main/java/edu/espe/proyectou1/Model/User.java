package edu.espe.proyectou1.Model;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private String id;
    private String name;
    private String lastname;
    private String phone;
    private String email;
    private String state;
    private String idRol;

    public User(String id, String name, String lastname, String phone, String email, String state, String idRol) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.state = state;
        this.idRol = idRol;
    }
}
