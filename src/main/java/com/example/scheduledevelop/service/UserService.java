package com.example.scheduledevelop.service;


import com.example.scheduledevelop.dto.RequestDto;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.UserRepository;
import jakarta.persistence.metamodel.SingularAttribute;
import lombok.Getter;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static User getUserById(SingularAttribute<AbstractPersistable, Serializable> id) {
        return null;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
    }

    public void updateUser(Long id, String username, String email) {
        User user = getUserById(id);
        user.update(username, email);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void createUser(RequestDto requestDto) {
    }
}
