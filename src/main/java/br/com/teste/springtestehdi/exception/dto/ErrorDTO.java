package br.com.teste.springtestehdi.exception.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private Integer status;
    private String error;
    private String message;
}
