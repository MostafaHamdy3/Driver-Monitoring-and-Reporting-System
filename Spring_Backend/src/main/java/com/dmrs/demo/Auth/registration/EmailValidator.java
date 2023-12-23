package com.dmrs.demo.Auth.registration;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Component
public class EmailValidator implements Predicate<String> {

  private static final Predicate<String> IS_EMAIL_VALID =
    Pattern.compile(
      "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
      Pattern.CASE_INSENSITIVE
    ).asPredicate();

  @Override
  public boolean test(String email) {
    return IS_EMAIL_VALID.test(email);
  }
}
