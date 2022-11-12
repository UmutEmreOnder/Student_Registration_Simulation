package edu.marmara.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public abstract class Person {
    private UUID uuid;
    private String name;
    private String surname;
    private String email;
    private Date birthDate;
}
