package br.com.uniportal.bussiness.users.entity;

import java.util.UUID;
import org.springframework.data.annotation.Id;

public class User {
    @Id
    private UUID id;
    private String name;
    private String login;
    private String document;
    private String password;
    private PersonType personType;
    private ProfileType type;

    public UUID getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public PersonType getPersonType() {
        return personType;
    }
    public ProfileType getType() {
        return type;
    }
    public String getDocument() {
        return document;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}