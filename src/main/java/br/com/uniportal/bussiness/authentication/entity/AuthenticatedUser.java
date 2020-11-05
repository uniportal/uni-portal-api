package br.com.uniportal.bussiness.authentication.entity;
import java.util.UUID;
import org.bson.types.Binary;


public class AuthenticatedUser {
	private UUID id;

	private String name;
    private String login;

    public AuthenticatedUser() {}
    
    public AuthenticatedUser(UUID id, String name, String login) {
        this.id = id;
        this.name = name;
        this.login = name;
    }


    public UUID getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }
}