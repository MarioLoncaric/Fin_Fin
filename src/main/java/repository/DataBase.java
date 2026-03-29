package repository;

import model.Client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    public static List<Client> bazaKlijenata(){

        List<Client> klijenti = new ArrayList<>();
        klijenti.add(new Client.ClientBuilder("Ana", "Horvat", "10000000001").email("ana.h@mail.hr").birthday(LocalDate.of(1990, 5, 12)).build());
        klijenti.add(new Client.ClientBuilder("Ivan", "Kovačević", "10000000002").email("ivan.k@mail.hr").birthday(LocalDate.of(1985, 8, 23)).build());
        klijenti.add(new Client.ClientBuilder("Marko", "Babić", "10000000003").birthday(LocalDate.of(2001, 2, 14)).build()); // Bez emaila
        klijenti.add(new Client.ClientBuilder("Petra", "Marić", "10000000004").email("petra.m@mail.com").birthday(LocalDate.of(1978, 11, 30)).build());
        klijenti.add(new Client.ClientBuilder("Luka", "Jurić", "10000000005").email("luka.j@firma.hr").build()); // Bez datuma rođenja
        klijenti.add(new Client.ClientBuilder("Marija", "Novak", "10000000006").email("marija.n@mail.hr").birthday(LocalDate.of(1995, 7, 7)).build());
        klijenti.add(new Client.ClientBuilder("Josip", "Kovačić", "10000000007").birthday(LocalDate.of(1965, 3, 22)).build());
        klijenti.add(new Client.ClientBuilder("Ivana", "Knežević", "10000000008").email("ivana.k@mail.hr").birthday(LocalDate.of(1988, 9, 15)).build());
        klijenti.add(new Client.ClientBuilder("Stjepan", "Vuković", "10000000009").email("stjepan.v@mail.com").birthday(LocalDate.of(1955, 12, 1)).build());
        klijenti.add(new Client.ClientBuilder("Katarina", "Marković", "10000000010").email("kate.m@mail.hr").birthday(LocalDate.of(2003, 4, 18)).build());

        klijenti.add(new Client.ClientBuilder("Tomislav", "Petrović", "10000000011").birthday(LocalDate.of(1982, 1, 25)).build());
        klijenti.add(new Client.ClientBuilder("Jelena", "Matić", "10000000012").email("jelena.m@mail.hr").build());
        klijenti.add(new Client.ClientBuilder("Karlo", "Tomić", "10000000013").email("karlo.t@mail.com").birthday(LocalDate.of(1999, 10, 5)).build());
        klijenti.add(new Client.ClientBuilder("Lucija", "Kovač", "10000000014").email("lucija.k@mail.hr").birthday(LocalDate.of(1992, 6, 17)).build());
        klijenti.add(new Client.ClientBuilder("Filip", "Pavlović", "10000000015").birthday(LocalDate.of(1970, 8, 8)).build());
        klijenti.add(new Client.ClientBuilder("Martina", "Božić", "10000000016").email("martina.b@mail.hr").birthday(LocalDate.of(1986, 12, 24)).build());
        klijenti.add(new Client.ClientBuilder("Antonio", "Blažević", "10000000017").email("antonio.b@firma.hr").birthday(LocalDate.of(1994, 3, 11)).build());
        klijenti.add(new Client.ClientBuilder("Matea", "Grgić", "10000000018").birthday(LocalDate.of(2005, 5, 29)).build());
        klijenti.add(new Client.ClientBuilder("Mario", "Pavić", "10000000019").email("mario.p@mail.com").build());
        klijenti.add(new Client.ClientBuilder("Maja", "Radić", "10000000020").email("maja.r@mail.hr").birthday(LocalDate.of(1980, 2, 2)).build());

        klijenti.add(new Client.ClientBuilder("Nikola", "Perić", "10000000021").birthday(LocalDate.of(1997, 9, 9)).build());
        klijenti.add(new Client.ClientBuilder("Iva", "Bačić", "10000000022").email("iva.b@mail.hr").birthday(LocalDate.of(1991, 11, 14)).build());
        klijenti.add(new Client.ClientBuilder("Željko", "Jukić", "10000000023").email("zeljko.j@mail.com").birthday(LocalDate.of(1960, 7, 21)).build());
        klijenti.add(new Client.ClientBuilder("Nikolina", "Filipović", "10000000024").birthday(LocalDate.of(1984, 4, 30)).build());
        klijenti.add(new Client.ClientBuilder("Goran", "Vidović", "10000000025").email("goran.v@mail.hr").build());
        klijenti.add(new Client.ClientBuilder("Sanja", "Šarić", "10000000026").email("sanja.s@mail.hr").birthday(LocalDate.of(1975, 1, 10)).build());
        klijenti.add(new Client.ClientBuilder("Denis", "Lovrić", "10000000027").birthday(LocalDate.of(1998, 8, 16)).build());
        klijenti.add(new Client.ClientBuilder("Mirjana", "Barišić", "10000000028").email("mirjana.b@mail.com").birthday(LocalDate.of(1968, 10, 28)).build());
        klijenti.add(new Client.ClientBuilder("Igor", "Zorić", "10000000029").email("igor.z@firma.hr").birthday(LocalDate.of(1989, 5, 5)).build());
        klijenti.add(new Client.ClientBuilder("Branka", "Rukavina", "10000000030").birthday(LocalDate.of(1950, 12, 15)).build());
        return klijenti;
    }

}
