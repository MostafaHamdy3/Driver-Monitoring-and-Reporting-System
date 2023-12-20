package com.dmrs.demo.driver;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import java.util.Optional;

public interface DriverRepository extends MongoRepository<Driver,String> {


     @Query("{ 'email' : ?0 }")
    Optional<Driver> findByEmail(String email);
    void deleteDriverByEmail(String Email);

    @Query("{ 'email' : ?0 }")
    @Update("{ $set: { 'enabled' : ?1 } }")
    void updateEnabledByEmail(String email, boolean enabled);

  @Query("{ 'email' : ?0.email }")
  @Update("{ $set: { 'firstName' : ?0.firstName, 'lastName' : ?0.lastName, 'phone' : ?0.phone, 'gender':?.gender,}")
    void update(Driver driver);
}
