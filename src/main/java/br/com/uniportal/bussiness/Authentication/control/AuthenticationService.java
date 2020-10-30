package br.com.uniportal.bussiness.Authentication.entity.control;

import br.com.uniportal.bussiness.Authentication.entity.AuthenticatedUser;
import br.com.uniportal.bussiness.Authentication.entity.Authentication;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    
    public AuthenticationService() {}

    public AuthenticatedUser authenticate(Authentication authentication) {
        return new AuthenticatedUser(UUID.randomUUID(), "victor", "victorjsantos");
    }

}