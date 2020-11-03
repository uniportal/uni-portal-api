package br.com.uniportal.bussiness.users.control;

import org.springframework.stereotype.Service;

import br.com.uniportal.bussiness.users.entity.User;
import br.com.uniportal.shared.api.error.UniPortalException;

@Service
public class UserService {

    public UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByLogin(String login) {
        if (login == null)
            throw UniPortalException.ofValidation("Login obrigatório.");

        return userRepository.getUserByLogin(login);
    }
}