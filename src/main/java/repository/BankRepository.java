package repository;

import model.BankAccount;
import model.Client;

import java.util.*;

public class BankRepository <T extends BankAccount>{

    private Set<Client> klijenti = new HashSet<>();
    private Map<String, T> racuni = new HashMap<>();

    public void dodajKlijenti(Client c){

    }

    public void dodajRacun(T racun){

    }

    public void obradiSve(List<? extends T> lista){

    }

}
