package br.com.uniportal.bussiness.authentication.entity;
import br.com.uniportal.shared.api.error.UniPortalException;

public class Authentication {
    private  String login;
    private String password;
    
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void validate() {
        if (password == null) {
            throw UniPortalException.ofValidation("Senha obrigatório.");
        }
    }
}