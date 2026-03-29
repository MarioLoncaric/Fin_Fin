package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Client implements Serializable {
    private final String name;
    private final String surname;
    private final String oib;
    private final String email;
    private final LocalDate birthday;

    private transient String lozinka = "TajnaLozinka123";

    private Client(ClientBuilder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.oib = builder.oib;
        this.email = builder.email;
        this.birthday = builder.birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getOib() {
        return oib;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Client client)) return false;
        return Objects.equals(oib, client.oib);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(oib);
    }

    public static class ClientBuilder{
        private final String name;
        private final String surname;
        private final String oib;

        private String email = "";
        private LocalDate birthday = null;

        public ClientBuilder(String name, String surname, String oib){
            this.name = name;
            this.surname = surname;
            this.oib = oib;
        }

        public ClientBuilder email(String email){
            this.email = email;
            return this;
        }

        public ClientBuilder birthday(LocalDate birthday){
            this.birthday = birthday;
            return this;
        }

        public Client build(){
            return new Client(this);
        }

    }
}
