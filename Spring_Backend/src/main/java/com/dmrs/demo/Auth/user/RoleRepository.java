package com.dmrs.demo.Auth.user;

import com.dmrs.demo.driver.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role,String> {


    Optional<Role> findByAuthority(String role);
}
