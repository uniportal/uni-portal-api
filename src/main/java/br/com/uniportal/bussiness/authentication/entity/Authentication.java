package br.com.uniportal.bussiness.authentication.entity;
import br.com.uniportal.shared.api.error.UniPortalException;

public class Authentication {
    private  String login;
    private String password;

    public Authentication() {}
    
    public Authentication(String login, String password) {
        this.login = login;
        this.password = password;
    }
    
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