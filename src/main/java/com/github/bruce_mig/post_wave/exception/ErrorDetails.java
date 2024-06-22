package com.github.bruce_mig.post_wave.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {
    private LocalDateTime timeStamp;
    private String message;
    private String details;
}
