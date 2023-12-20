package com.dmrs.demo.Auth.login;


import com.dmrs.demo.DmrsApplication;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/login")
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @CrossOrigin(origins = DmrsApplication.crossOriginLink)
    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }


}
