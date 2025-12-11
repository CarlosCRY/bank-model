package org.ies.tierno.banco.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Account {
    private String iban;
    private double balance;
    private Client client;

    public void showInfo() {
        System.out.println("\n" + iban + " asociada a " + client.getSurname() + ", " + client.getName() + ", con saldo: " + balance);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if ((balance - amount) < 0){
            System.out.println("\nLa cuenta no contiene suficiente saldo. Transacción cancelada.");
        } else {
            balance -= amount;
        }
    }
}
