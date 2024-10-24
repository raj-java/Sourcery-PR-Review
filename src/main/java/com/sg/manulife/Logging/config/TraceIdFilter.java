package com.sg.manulife.Logging.config;

import io.micrometer.tracing.Tracer;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
@Slf4j
public class TraceIdFilter extends OncePerRequestFilter {
  private final Tracer tracer;

  public TraceIdFilter(Tracer tracer) {
    this.tracer = tracer;
  }

  @Override
  public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String traceId = Optional.ofNullable(tracer.currentSpan())
      .map(span -> span.context().traceId())
      .orElse("UNKNOWN");
    response.addHeader("TraceId", traceId);
    log.info("Trace ID: {}", traceId);
    filterChain.doFilter(request, response);
  }
}
