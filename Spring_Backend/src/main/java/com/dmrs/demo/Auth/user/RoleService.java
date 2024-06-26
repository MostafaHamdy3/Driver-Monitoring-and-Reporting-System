package com.dmrs.demo.Auth.user;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getRole(String role) {
        return roleRepository.findByAuthority(role).get();
    }
}
