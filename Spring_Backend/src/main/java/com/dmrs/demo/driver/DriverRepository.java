package com.dmrs.demo.driver;

import com.dmrs.demo.Auth.user.ApplicationUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import java.util.Optional;

public interface DriverRepository extends MongoRepository<Driver,String> {
    Optional<Driver> findByUser(ApplicationUser user);


//     @Query("{ 'username' : ?0 }")
//    Optional<Driver> findByEmail(String username);
//    void deleteDriverByEmail(String Email);

//    @Query("{ 'username' : ?0 }")
//    @Update("{ $set: { 'enabled' : ?1 } }")
//    void updateEnabledByEmail(String username, boolean enabled);
//
//  @Query("{ 'username' : ?0.username }")
//  @Update("{ $set: { 'firstName' : ?0.firstName, 'lastName' : ?0.lastName, 'phone' : ?0.phone, 'gender':?.gender,}")
//    void update(Driver driver);
}
