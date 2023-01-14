package com.example.demo.restapijvs.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpHeaders;

@NoArgsConstructor
public class ResponseApi<T> {
    @Getter
    @Setter
    private int code;
    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private String status;
    @Getter
    @Setter
    private T data;
    
    public ResponseApi(int code, String message, String status, T data) {
        this.code = code;
        this.message = message;
        this.status = status;
        this.data = data;
    }
}
