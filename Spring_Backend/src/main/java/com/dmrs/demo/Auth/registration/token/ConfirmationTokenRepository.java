package com.dmrs.demo.Auth.registration.token;


import com.dmrs.demo.driver.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ConfirmationTokenRepository
        extends MongoRepository<ConfirmationToken, Long> {

    Optional<ConfirmationToken> findByToken(String token);

    @Transactional
    @Query("{ 'token' : ?0 }")
    @Update("{ $set: { 'confirmedAt' : ?1 } }")
    void updateConfirmedAt(String token,
                                   LocalDateTime confirmedAt);

//  @Query("{ 'driver' : ?0 }")
  Optional<ConfirmationToken> findByDriver(Driver driver);
}
