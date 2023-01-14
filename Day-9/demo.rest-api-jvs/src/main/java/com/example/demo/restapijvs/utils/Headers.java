package com.example.demo.restapijvs.utils;

import org.springframework.http.HttpHeaders;
import java.util.UUID;

public class Headers {
    public String GenerateCorrelationId() {
        String correlationId = UUID.randomUUID().toString();
        return correlationId;
    }

    public HttpHeaders SetCorrelationId(String correlationId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Correlation-Id", correlationId);
        return headers;
    }
}
