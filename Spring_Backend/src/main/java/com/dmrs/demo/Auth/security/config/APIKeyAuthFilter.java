package com.dmrs.demo.Auth.security.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class APIKeyAuthFilter extends OncePerRequestFilter {
    private final String HEADER_NAME = "CAR-API-KEY";
    private final String API_KEY = System.getenv("API_KEY"); // Replace with your actual API key

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String apiKey = request.getHeader(HEADER_NAME);

        if (request.getRequestURI().equals("/api/v1/trips")&& request.getMethod().equals("POST")&& API_KEY.equals(apiKey)) {
            PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(apiKey, null, null);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        else if (request.getRequestURI().equals("/api/v1/trips")&& request.getMethod().equals("POST")&& !API_KEY.equals(apiKey)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid API key");
            return;

        }

        filterChain.doFilter(request, response);
    }
}
