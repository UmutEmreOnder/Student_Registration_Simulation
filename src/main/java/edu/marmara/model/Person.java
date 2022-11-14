package edu.marmara.model;

import java.util.Date;
import java.util.UUID;


public abstract class Person {
    private UUID uuid;
    private String name;
    private String surname;
    private String email;
    private Date birthDate;

    public Person() {
    }

    public Person(UUID uuid, String name, String surname, String email, Date birthDate) {
        this.uuid = uuid;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
