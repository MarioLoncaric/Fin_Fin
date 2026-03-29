package model;

import exceptions.BankException;

import java.math.BigDecimal;

public sealed interface Transactioning permits BankAccount {

    void deposit(BigDecimal price);

    void withdraw(BigDecimal price) throws BankException;




}
