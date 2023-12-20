package com.dmrs.demo.Auth.registration.token;

import com.dmrs.demo.driver.Driver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getTokenByDriver(Driver driver) {
        return confirmationTokenRepository.findByDriver(driver);
    }

  public Optional<ConfirmationToken> getToken(String driverId) {
    return confirmationTokenRepository.findByToken(driverId);
  }

    public int setConfirmedAt(String token) {
        confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
        return 1;
    }
}
