package model;

import exceptions.InsufficientFundsException;

import java.math.BigDecimal;

public non-sealed class SavingsAccount extends BankAccount {

    private BigDecimal interestRate;

    public SavingsAccount(Client owner, BigDecimal balance, String iban, BigDecimal interestRate) {
        super(owner, balance, iban);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }

    @Override
    public void withdraw(BigDecimal amount) throws InsufficientFundsException {

        if(amount.compareTo(this.balance) > 0){
            throw new InsufficientFundsException("Nemate dovoljno sredstva na racunu");
        }

        this.balance = this.balance.subtract(amount);
    }
}
