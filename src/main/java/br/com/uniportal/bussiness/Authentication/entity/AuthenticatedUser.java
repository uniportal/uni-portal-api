package br.com.uniportal.bussiness.Authentication.entity;
import java.util.UUID;

import org.springframework.data.annotation.Id;

public class AuthenticatedUser {
    @Id
	private UUID id;

	private String name;
    private String login;

    public AuthenticatedUser() {}
    
    public AuthenticatedUser(UUID id, String name, String login) {
        this.id = id;
        this.name = name;
        this.login = name;
    }

}