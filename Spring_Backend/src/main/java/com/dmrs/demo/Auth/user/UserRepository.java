package com.dmrs.demo.Auth.user;

import com.dmrs.demo.driver.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<ApplicationUser,String> {

    Optional<ApplicationUser> findByUsername(String username);
}
