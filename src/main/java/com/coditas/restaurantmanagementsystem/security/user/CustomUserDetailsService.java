package com.coditas.restaurantmanagementsystem.security.user;

import com.coditas.restaurantmanagementsystem.constants.ExceptionConstants;
import com.coditas.restaurantmanagementsystem.entity.User;
import com.coditas.restaurantmanagementsystem.repository.UserRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        Optional<User> userByUsername = userRepository.findByUsername(username);
        Optional<User> userByEmail = userRepository.findByEmail(username);
        if(userByUsername.isPresent()) return userByUsername.get();
        else if(userByEmail.isPresent()) return userByEmail.get();
        else throw new UsernameNotFoundException(ExceptionConstants.USERNAME_NOT_FOUND);
    }
}
