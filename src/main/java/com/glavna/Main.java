package com.glavna;

import exceptions.BankException;
import model.BankAccount;
import model.Client;
import model.FlowAccount;
import model.SavingsAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.DataBase;
import services.BankManager;

import javax.lang.model.element.Name;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    static void main() {

        BankManager manager = new BankManager();

        // Dohvaćamo klijente iz baze
        List<Client> klijenti = DataBase.bazaKlijenata();

        // Kreiramo listu računa za testiranje
        List<BankAccount> testniRacuni = new ArrayList<>();

        // Racun u dubokom plusu
        testniRacuni.add(new SavingsAccount(klijenti.get(0), BigDecimal.valueOf(5000), "HR001", BigDecimal.valueOf(0.05)));

        // Racun u minusu
        testniRacuni.add(new FlowAccount(klijenti.get(1), BigDecimal.valueOf(-300), "HR002", BigDecimal.valueOf(1000)));

        // Još jedan racun u minusu
        testniRacuni.add(new FlowAccount(klijenti.get(2), BigDecimal.valueOf(-50), "HR003", BigDecimal.valueOf(500)));

        // Racun s malo novca
        testniRacuni.add(new FlowAccount(klijenti.get(3), BigDecimal.valueOf(150), "HR004", BigDecimal.valueOf(500)));

        // 1. Testiramo pronalazak računa u minusu
        List<BankAccount> minusi = manager.pronadjiRacuneUMinusu(testniRacuni);
        log.info("Pronađeno računa u minusu: {}", minusi.size());
        minusi.forEach(r -> log.info("IBAN: {} je u minusu: {}", r.getIban(), r.getBalance()));

        // 2. Testiramo izračun ukupnog kapitala (5000 - 300 - 50 + 150 = 4800)
        BigDecimal ukupniKapital = manager.izracunajUkupniKapitalBanke(testniRacuni);
        log.info("Ukupni kapital svih učitanih računa iznosi: {} EUR", ukupniKapital);
    }
}

