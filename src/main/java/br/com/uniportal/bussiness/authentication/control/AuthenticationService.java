package br.com.uniportal.bussiness.authentication.entity.control;

import br.com.uniportal.bussiness.authentication.entity.AuthenticatedUser;
import br.com.uniportal.bussiness.users.control.UserService;
import br.com.uniportal.bussiness.users.entity.User;
import br.com.uniportal.shared.api.error.UniPortalException;
import br.com.uniportal.shared.api.response.ApiReturn;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    
    private UserService userService;

    public AuthenticationService(UserService userService) {
      this.userService = userService;
    }

    public AuthenticatedUser authenticate(br.com.uniportal.bussiness.authentication.entity.Authentication authentication) {
        if (authentication == null || authentication.getLogin() == null) {
           throw UniPortalException.ofValidation("Login obrigatório.");
        }

        authentication.validate();

        User user = userService.getUserByLogin(authentication.getLogin());

        if (user == null)
            throw UniPortalException.ofValidation("Usuário não encontrado.");

        if (!this.validatePassword(authentication.getPassword(), user.getPassword()))
            throw UniPortalException.ofValidation("Senha inválida.");
        
        return new AuthenticatedUser(user.getId(), user.getName(), user.getLogin(), user.getDocument());
    }

    public Boolean validatePassword(String password, String authenticatioPassword) {
      return password.equals(authenticatioPassword);
    }
}