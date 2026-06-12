package com.amor.infrastructure.web.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ApiSecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        
        // Somente protege as rotas de API
        if (path.startsWith("/api/")) {
            
            // Permite passagem livre para o pre-flight do CORS (OPTIONS)
            if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
                response.setHeader("Access-Control-Allow-Headers", "*");
                response.setStatus(HttpServletResponse.SC_OK);
                return;
            }

            String authHeader = request.getHeader("X-Auth-Token");

            // Regra de segurança: O token precisa ser a senha dela ou a sua senha Admin
            if (authHeader == null || (!authHeader.equals("florzinha") && !authHeader.equals("chefe"))) {
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.getWriter().write("{\"error\": \"Acesso não autorizado! A porta digital está trancada.\"}");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
