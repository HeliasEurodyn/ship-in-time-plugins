package com.ed.tenacityxml.service.user;

import com.ed.tenacityxml.dto.user.SoftoneUserDTO;
import com.ed.tenacityxml.repository.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerNewUser(SoftoneUserDTO softoneUser) {
        this.userRepository.registerNewUser(softoneUser);
    }

}
