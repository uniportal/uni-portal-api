package br.com.uniportal.bussiness.authentication.entity;

import org.bson.types.Binary;

public class AuthenticatedUser {
	private Binary id;

	private String name;
    private String login;

    public AuthenticatedUser() {}
    
    public AuthenticatedUser(Binary id, String name, String login) {
        this.id = id;
        this.name = name;
        this.login = name;
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

}