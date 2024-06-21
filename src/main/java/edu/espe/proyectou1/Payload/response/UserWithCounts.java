package edu.espe.proyectou1.Payload.response;

import edu.espe.proyectou1.Model.User;
import lombok.Data;

@Data
public class UserWithCounts {
    private User user;
    private String numProjects;
    private String numTasks;
}
