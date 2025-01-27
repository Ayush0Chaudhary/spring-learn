package com.example.triomics.utils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Component
public class LoggingFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String traceId = request.getHeader("triomics-trace-id");
        if (traceId == null) {
            traceId = UUID.randomUUID().toString();
            request.setAttribute("triomics-trace-id", traceId);
            log.info(traceId);
        }
        ThreadContext.put("traceId", traceId); // Add traceId to MDC
        try {
            filterChain.doFilter(request, response);
        } finally {
            ThreadContext.clearAll(); // Clear MDC to avoid memory leaks
        }
    }
}
