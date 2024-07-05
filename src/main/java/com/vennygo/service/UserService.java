package com.vennygo.service;

import com.vennygo.entity.User;
import com.vennygo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserByLoginId(String loginId) {
        return userRepository.findByLoginId(loginId);
    }
}
