package edu.espe.proyectou1.Model;

import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;

@Data
public class Rol {
    private String id;
    private String name;
    private String description;

    public Rol(String id, String name, String description) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
    }
}
