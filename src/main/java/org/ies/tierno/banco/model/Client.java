package org.ies.tierno.banco.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Client {
    private String nif;
    private String name;
    private String surname;

    public void showInfo() {
        System.out.println("\n" + surname + ", " + name + ", NIF: " + nif);
    }
}