package services;

import exceptions.BankException;
import model.BankAccount;
import model.Client;
import model.FlowAccount;
import model.SavingsAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.DataBase;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.stream;

public class BankManager {
    private static final Logger log = LoggerFactory.getLogger(BankManager.class);

    public void obradiMjesecniObracun(BankAccount racun) throws BankException{

        if(racun instanceof SavingsAccount sa){
            log.info("Obrađujem štedni račun...");
            sa.withdraw(BigDecimal.valueOf(5));
        }
        else if (racun instanceof FlowAccount fa) {
            log.info("Obrađujem tekući račun...");
            fa.deposit(BigDecimal.valueOf(10));
        }

    }

    public void ucitajPravilaBanke() throws BankException{
        try(BufferedReader rd = new BufferedReader(new FileReader("nepostojeca_datoteka.txt"))){

        } catch(IOException | RuntimeException ex){
            log.error(ex.getMessage());
            throw new BankException("Kritična greška sustava banke", ex);
        }
    }

    public void sortirajIspisiKlijente(List<Client> klijenti){

        klijenti.sort(Comparator.comparing(Client::getBirthday, Comparator.nullsLast(Comparator.naturalOrder())));

        klijenti.forEach(k -> log.info("{} {} | Rođen: {}", k.getName(), k.getSurname(), k.getBirthday() != null ? k.getBirthday() : "Nepoznato"));

    }

    public void ispisiTop3Klijenata(List<BankAccount> racuni){

        racuni.sort(Comparator.comparing(BankAccount::getBalance).reversed());

        racuni.forEach(racun -> log.info("IBAN: {} | Stanje: {} EUR", racun.getIban(), racun.getBalance()));

    }

    public List<BankAccount> pronadjiRacuneUMinusu(List<BankAccount> racuni){

        return racuni.stream().filter(r -> r.getBalance().compareTo(BigDecimal.ZERO) < 0).toList();
    }

    public BigDecimal izracunajUkupniKapitalBanke(List<BankAccount> racuni){
        return racuni.stream().map(BankAccount::getBalance).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // --- 1. SPREMANJE (BINARNO IO) ---
    public void spremiStanje(List<Client> klijenti) {
        log.info("--- POKREĆEM SPREMANJE STANJA U TREZOR ---");
        // Koristimo try-with-resources za automatsko zatvaranje streamova
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("trezor.dat"))) {

            oos.writeObject(klijenti);
            log.info("Uspješno spremljeno {} klijenata u trezor.dat", klijenti.size());

        } catch (IOException e) {
            log.error("Kritična greška pri spremanju u trezor: {}", e.getMessage());
        }
    }

    // --- 2. UČITAVANJE (BINARNO IO) ---
    @SuppressWarnings("unchecked")
    public List<Client> ucitajStanje() {
        log.info("--- POKREĆEM UČITAVANJE STANJA IZ TREZORA ---");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("trezor.dat"))) {

            List<Client> ucitaniKlijenti = (List<Client>) ois.readObject();
            log.info("Uspješno učitano {} klijenata iz trezor.dat", ucitaniKlijenti.size());
            return ucitaniKlijenti;

        } catch (FileNotFoundException e) {
            log.warn("Datoteka trezor.dat još ne postoji (Prvo pokretanje sustava).");
            return new ArrayList<>(); // Vraćamo praznu listu ako datoteka ne postoji
        } catch (IOException | ClassNotFoundException e) {
            log.error("Kritična greška pri čitanju trezora: {}", e.getMessage());
            return new ArrayList<>();
        }
    }

    // --- 3. TEKSTUALNI IZVJEŠTAJ (MODERNI NIO.2) ---
    public void generirajIzvjestaj(List<BankAccount> racuni) {
        log.info("--- GENERIRAM DNEVNI IZVJEŠTAJ (NIO.2) ---");

        // Pozivamo metodu od prošlog tjedna
        BigDecimal ukupniKapital = izracunajUkupniKapitalBanke(racuni);

        String tekstIzvjestaja = "=== DNEVNI IZVJEŠTAJ BANKE ===\n" +
                "Ukupni kapital: " + ukupniKapital + " EUR\n" +
                "Broj aktivnih računa: " + racuni.size() + "\n" +
                "==============================\n";

        try {
            Path putanja = Path.of("izvjestaj.txt");
            Files.writeString(putanja, tekstIzvjestaja); // NIO.2 metoda iz Jave 11+
            log.info("Izvještaj je uspješno kreiran na putanji: izvjestaj.txt");
        } catch (IOException e) {
            log.error("Greška pri generiranju izvještaja: {}", e.getMessage());
        }
    }

}
