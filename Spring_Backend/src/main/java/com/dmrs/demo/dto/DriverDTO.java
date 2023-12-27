package com.dmrs.demo.dto;


import com.dmrs.demo.driver.Gender;

public record DriverDTO(
   String id,
   String firstName,
   String lastName,
   String email,
   Gender gender,
   int age,
   String phone,
   String jobTitle,
   String imgUrl
) {
}
