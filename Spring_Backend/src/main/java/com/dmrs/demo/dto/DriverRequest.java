package com.dmrs.demo.dto;

import com.dmrs.demo.driver.Gender;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class DriverRequest {
  private String id;
  private String firstName;
  private String lastName;
  private Gender gender;
  private String phone;
  private String email;
  private String password;
  private String jobTitle;
  private String imgUrl;
  private int age;
  private int score;

}
