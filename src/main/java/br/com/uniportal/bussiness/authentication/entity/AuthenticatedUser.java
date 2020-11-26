package br.com.uniportal.bussiness.authentication.entity;

import org.bson.types.Binary;

public class AuthenticatedUser {
	private Binary id;

	private String name;
    private String login;
    private String document;

    public AuthenticatedUser() {}
    
    public AuthenticatedUser(Binary id, String name, String loginm, String document) {
        this.id = id;
        this.name = name;
        this.login = name;
        this.document = document;
    }


    public Binary getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

}