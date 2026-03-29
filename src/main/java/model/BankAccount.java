package model;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract sealed class BankAccount implements Transactioning, Serializable permits FlowAccount, SavingsAccount {

    protected Client owner;
    protected BigDecimal balance;
    protected String iban;

    public BankAccount(Client owner, BigDecimal balance, String iban){
        this.owner = owner;
        this.balance = balance;
        this.iban = iban;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
