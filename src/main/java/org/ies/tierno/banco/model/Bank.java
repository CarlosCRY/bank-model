package org.ies.tierno.banco.model;

import java.util.Arrays;
import java.util.Objects;

public class Bank {
    private String name;
    private Account[] accounts;

    public Bank (String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public void allInfo () {
        for (Account account: accounts) {
            System.out.println(account.getIban() + ", saldo: " + account.getBalance() + ", NIF asociado: "
                    + account.getClient().getNif());
        }
    }

    public void searchIbanAccount (String x) {
        for (Account account: accounts) {
            if (account.getIban().equals(x)) {
                account.showInfo();
                break;
            }
        }
    }

    public Account findAccount (String x) {
        for (Account account: accounts) {
            if (account.getIban().equals(x)) {
                return account;
            }
        }
        return null;
    }

    public void searchNifAccounts (String x) {
        for (Account account: accounts) {
            if (account.getClient().getNif().equals(x)) {
                account.showInfo();
            }
        }
    }

    public void depositIban (String x, double y) {
        for (Account account : accounts) {
            if (account.getIban().equals(x)) {
                account.deposit(y);
                return;
            }
        }
        System.out.println("\nNo se ha podido encontrar la cuenta por el IBAN dado.");
    }

    public int countNIFAccounts (String x) {
        int y = 0;
        for (Account account: accounts) {
            if (account.getClient().getNif().equals(x)) {
                y++;
            }
        }
        return y;
    }

    public Client searchIbanClient (String x) {
        for (Account account: accounts) {
            if (account.getIban().equals(x)) {
                return account.getClient();
            }
        }
        return null;
    }

    public void transferIban (String x, String y, double z) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getIban().equals(x)) {
                for (int j = 0; j < accounts.length; j++) {
                    if (accounts[j].getIban().equals(y)) {
                        accounts[i].withdraw(z);
                        if (accounts[i].getBalance() >= z) {
                            depositIban(y, z);
                        }
                        break;
                    }
                    if (j == accounts.length -1) {
                        System.out.println("\nNo se ha encontrado la cuenta de destino.");
                        System.out.println("Operación cancelada.\n");
                    }
                }
                break;
            }
            if (i == accounts.length -1) {
                System.out.println("\nNo se ha encontrado la cuenta de origen.");
                System.out.println("Operación cancelada.\n");
            }
        }
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Account[] getAccounts () {
        return accounts;
    }

    public void setAccounts (Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}

