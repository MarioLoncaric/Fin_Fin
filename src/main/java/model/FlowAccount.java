package model;

import java.math.BigDecimal;

public final class FlowAccount extends BankAccount{

    private BigDecimal allowedMinus;

    public FlowAccount(Client owner, BigDecimal balance, String iban, BigDecimal allowedMinus){
        super(owner, balance, iban);
        this.allowedMinus = allowedMinus;
    }

    @Override
    public void deposit(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }

    @Override
    public void withdraw(BigDecimal amount){
        this.balance = this.balance.subtract(amount);
    }

}
