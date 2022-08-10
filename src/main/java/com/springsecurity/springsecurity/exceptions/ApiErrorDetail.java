package com.springsecurity.springsecurity.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiErrorDetail {
    private LocalDateTime timeStamp;
    private String message;
    private String details;

    public ApiErrorDetail(String message, String details) {
        this.timeStamp = LocalDateTime.now();
        this.message = message;
        this.details = details;
    }
}
