package com.dmrs.demo.Auth.registration.token;

import com.dmrs.demo.driver.Driver;

import com.mongodb.lang.NonNull;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


import java.time.LocalDateTime;


@ToString
@Getter
@Setter
@NoArgsConstructor
@Data
@Document
public class ConfirmationToken {

    private String id;

    @NonNull
    @Indexed(unique = true)
    private String token;

    @NonNull
    private LocalDateTime createdAt;

    @NonNull
    private LocalDateTime expiresAt;

    private LocalDateTime confirmedAt = null;

    @DocumentReference
    private Driver driver;

    public ConfirmationToken(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiresAt,
                             Driver driver) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.driver = driver;
    }
}