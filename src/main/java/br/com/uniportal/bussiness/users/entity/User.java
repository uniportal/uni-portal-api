package br.com.uniportal.bussiness.users.entity;

import org.bson.types.Binary;

public class User {
    private Binary id;
    private String name;
    private String document;
    private String login;
    private String password;
    private PersonType personType;
    private ProfileType type;

    public Binary getId() {
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
}