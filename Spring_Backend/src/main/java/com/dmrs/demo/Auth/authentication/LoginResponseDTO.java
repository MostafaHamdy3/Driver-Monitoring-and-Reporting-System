package com.dmrs.demo.Auth.authentication;

import com.dmrs.demo.Auth.user.ApplicationUser;

public record LoginResponseDTO (
        String userId,
        String jwt

) {}
