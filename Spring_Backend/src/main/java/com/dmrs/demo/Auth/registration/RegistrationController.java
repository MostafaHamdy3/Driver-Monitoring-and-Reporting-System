package com.dmrs.demo.Auth.registration;

import com.dmrs.demo.DmrsApplication;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @CrossOrigin(origins = DmrsApplication.crossOriginLink)
    @PostMapping
    public void register(@RequestBody RegistrationRequest request) {
         registrationService.register(request); // TODO: return a proper response
    }

    @CrossOrigin(origins = DmrsApplication.crossOriginLink)
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
