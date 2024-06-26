package com.dmrs.demo.Auth.authentication;

import com.dmrs.demo.Auth.user.ApplicationUser;
import com.dmrs.demo.dto.ResponsePayload;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<ResponsePayload> registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponsePayload> loginUser(@RequestBody LoginDTO body){
        return authenticationService.loginUser(body.username(), body.password());
    }
}
