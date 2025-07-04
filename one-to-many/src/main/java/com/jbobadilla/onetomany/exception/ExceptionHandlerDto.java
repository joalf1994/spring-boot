package com.jbobadilla.onetomany.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionHandlerDto {
    private LocalDateTime timestamp;
    private String tipo;
    private int statusCode;
    private String message;

}
