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

/**
 * LoggingFilter is a custom filter that ensures each request has a unique trace ID.
 * This trace ID is used for logging purposes to help trace the flow of a request through the system.
 * 
 * <p>This filter extends {@link OncePerRequestFilter} to guarantee that it is executed only once per request.
 * It uses SLF4J for logging and Apache Log4j's ThreadContext for managing the trace ID in the MDC (Mapped Diagnostic Context).
 * 
 * <p>Key functionalities:
 * <ul>
 *   <li>Checks for an existing trace ID in the request header "triomics-trace-id".</li>
 *   <li>If no trace ID is found, generates a new one and sets it as a request attribute.</li>
 *   <li>Adds the trace ID to the MDC for logging purposes.</li>
 *   <li>Ensures the MDC is cleared after the request is processed to prevent memory leaks.</li>
 * </ul>
 * 
 * @see OncePerRequestFilter
 * @see ThreadContext
 */
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
