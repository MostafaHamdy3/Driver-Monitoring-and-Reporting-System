package com.dmrs.demo.Auth.user;

import com.dmrs.demo.exception.ApiRequestException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User is not valid"));
    }

    public ApplicationUser addUser(ApplicationUser applicationUser){
        return userRepository.save(applicationUser);
    }

    public void deleteUser (String username){
        ApplicationUser applicationUser = userRepository.findByUsername(username).orElseThrow(() -> new ApiRequestException("User not found"));
        userRepository.delete(applicationUser);
    }

    public ApplicationUser getUserByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(() -> new ApiRequestException("User not found"));
    }

    public ApplicationUser getUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ApiRequestException("User is not found"));
    }
}
