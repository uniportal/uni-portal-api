package br.com.uniportal.controller;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniportal.shared.api.controller.BaseController;
import br.com.uniportal.shared.api.response.ApiReturn;

import br.com.uniportal.bussiness.Authentication.entity.AuthenticatedUser;
import br.com.uniportal.bussiness.Authentication.entity.Authentication;
import br.com.uniportal.bussiness.Authentication.entity.control.AuthenticationService;


@RestController
@RequestMapping("authenticate")
public class AuthenticationController extends BaseController {

    private AuthenticationService authenticationService;

    public AuthenticationController(Executor executor, AuthenticationService authenticationService) {
        super(executor);
        this.authenticationService = authenticationService;
    }   

    @PostMapping()
    public CompletableFuture<ApiReturn<AuthenticatedUser>> authenticate(@RequestBody Authentication authentication) { 
        System.out.println(new AuthenticatedUser(UUID.randomUUID(), "victor", "victorjsantos").toString());
        return asyncResultOf(() -> new AuthenticatedUser(UUID.randomUUID(), "victor", "victorjsantos"));
    }
}