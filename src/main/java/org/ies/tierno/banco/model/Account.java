package org.ies.tierno.banco.model;

import java.util.Objects;

public class Account {
    private String iban;
    private double balance;
    private Client client;

    public Account (String iban, double balance, Client client) {
        this.iban = iban;
        this.balance = balance;
        this.client = client;
    }

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

    public String getIban () {
        return iban;
    }

    public void setIban (String iban) {
        this.iban = iban;
    }

    public double getBalance () {
        return balance;
    }

    public void setBalance (double balance) {
        this.balance = balance;
    }

    public Client getClient () {
        return client;
    }

    public void setClient (Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(balance, account.balance) == 0 && Objects.equals(iban, account.iban) && Objects.equals(client, account.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, balance, client);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", balance=" + balance +
                ", client=" + client +
                '}';
    }
}
