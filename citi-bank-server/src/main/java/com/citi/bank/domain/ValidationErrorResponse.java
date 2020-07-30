package com.citi.bank.domain;

import lombok.Data;

import java.util.List;

@Data
public class ValidationErrorResponse {

    private List<ErrorDetails> errors;

    @Data
    public static class ErrorDetails {
        private String fieldName;
        private String message;
    }
}