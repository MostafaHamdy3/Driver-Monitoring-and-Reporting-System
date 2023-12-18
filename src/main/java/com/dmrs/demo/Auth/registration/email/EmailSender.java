package com.dmrs.demo.Auth.registration.email;

public interface EmailSender {
    void send(String to, String email);
}